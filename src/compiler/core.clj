(ns compiler.core
  (:refer-clojure :exclude [read-string peek])
  (:import (java.io BufferedReader FileReader PushbackReader StringReader))
)


(comment Tabela de Hash para as palavras reservadas )
(defn init-word-table
  "Cria a tabela de símbolos contendo as palavras reservadas"
  []
  (hash-map
    "auto"       'auto
    "break"      'break
    "case"       'case
    "char"       'char
    "const"      'const
    "continue"   'continue
    "default"    'default
    "do"         'do
    "double"     'double
    "else"       'else
    "enum"       'enum
    "extern"     'extern
    "float"      'float
    "for"        'for
    "goto"       'goto
    "if"         'if
    "inline"     'inline
    "int"        'int
    "long"       'long
    "register"   'register
    "restrict"   'restrict
    "return"     'return
    "short"      'short
    "signed"     'signed
    "sizeof"     'sizeof
    "static"     'static
    "struct"     'struct
    "switch"     'switch
    "typedef"    'typedef
    "union"      'union
    "unsigned"   'unsigned
    "void"       'void
    "volatile"   'volatile
    "while"      'while
    "_Alignas"   '_Alignas
    "_Alignof"   '_Alignof
    "_Atomic"    '_Atomic
    "_Bool"      '_Bool
    "_Complex"   '_Complex
    "_Generic"   '_Generic
    "_Imaginary" '_Imaginary
    "_Noreturn"  '_Noreturn
    "_Static_assert" '_Static_assert
    "_Thread_local" '_Thread_local
  )
)

(def word-table (init-word-table))

(declare read-token)
(declare skip-spaces-and-comment)

; Comentários
(defn read-comment [rdr line col]
   (do (println "Entrando no comentario")
   (loop [c (.read rdr)
          ln line
          cl (inc col)]
     (cond (= c -1) 
             (list {:tag 'error
                    :type 'unfinished-comment
                    :start {:line line :col col}  
                    :end   {:line ln   :col cl }} 
                   c
                   ln cl)
           (#{\return \newline} (char c))
              (recur 
                 (.read rdr)
                 (inc ln)
                 1)
                 
           (= c (int \*))
              (let [c1 (.read rdr)
                    cl (inc cl)]
                (cond 
                      (= c1 (int \/))              ; * /
                         (do (println "Saindo do comentario" ln)
                            (skip-spaces-and-comment rdr (.read rdr) ln (inc cl)))
                      :else
                         (recur 
                            (.read rdr)
                            ln 
                            (inc cl))))

           :else
             (recur 
                (.read rdr)
                ln 
                (inc cl))))))
                
(defn read-line-comment [rdr line col]
   (do (println "Entrando no comentario de linha")
 
   (loop [c  (.read rdr)
          ln line
          cl (inc col)]
     (cond (= c -1) 
              (read-token rdr c ln cl)
           (#{\return \newline} (char c))  ; \n
            (do (println "Saindo do comentario de linha")
              (skip-spaces-and-comment rdr (.read rdr) (inc ln) 1))
          :else (recur 
                    (.read rdr) 
                    ln 
                    (inc cl))))))
                  
; Espaços em branco
(defn skip-spaces-and-comment [rdr ch line col]
   (loop [c ch
          ln line
          cl col]
     (cond 
           (= c (int \newline))
              (recur (.read rdr) (inc ln) 1)

           (Character/isWhitespace c) 
              (recur (.read rdr) ln (inc cl))

           (= c (int \/))
              (let [nextc (.read rdr)
                    cl (inc cl)]
                 (cond (= nextc (int \/))          ; //
                          (read-line-comment rdr ln cl)

                       (= nextc (int \*))          ; / *
                          (read-comment rdr ln cl)

                       :else                       ; /
                          (do (.unread rdr nextc)
                              (list c ln (dec cl)))))
           
           :else
              (list c ln cl))))   

; Identificadores e palavras-chaves
(defn read-keyword-or-id [rdr ch line col]
   (loop [c ch
          ln line
          cl col
          sb (StringBuilder.)]
     (cond (Character/isLetterOrDigit c) 
              (recur (.read rdr) 
                     ln 
                     (inc cl) 
                     (.append sb (Character/toString (char c))))
            :else (let [s (.toString sb)
                         w (word-table s) ]
                      (if w 
                          (list {:tag w 
                                 :start {:line line :col col}  
                                 :end   {:line ln   :col (dec cl) }} 
                                c
                                ln cl)
                          (list {:tag 'id
                                 :lexeme s 
                                 :start {:line line :col col}  
                                 :end   {:line ln   :col (dec cl) }} 
                                c 
                                ln cl))))))


; Números

(defn read-number [rdr ch line col]
   (loop [c ch
          ln line
          cl col
          v 0]
     (cond (Character/isDigit c) 
              (recur (.read rdr) 
                     ln 
                     (inc cl) 
                     (+ (* 10 v) (Character/digit c 10)))
           (= c -1) 
              (list {:tag 'int 
                     :value v 
                     :start {:line line :col col}  
                     :end   {:line ln   :col (dec cl) }} 
                    c 
                    ln cl)
           (= c (int \.)) ;Número real
              (loop [c (.read rdr)
                     ln ln
                     cl (inc cl)
                     x (float v)
                     d 10.0]
                 (cond (Character/isDigit c) 
                         (recur (.read rdr) 
                                ln 
                                (inc cl) 
                                (+ x (/ (Character/digit c 10) d))
                                (* d 10))
                       :else (list {:tag 'real 
                                     :value x 
                                     :start {:line line :col col}  
                                     :end   {:line ln   :col (dec cl) } } 
                                    c
                                    ln cl)))
           :else (list {:tag 'int 
                         :value v 
                         :start {:line line :col col}  
                         :end   {:line ln   :col (dec cl) }} 
                        c 
                        ln cl))))


; Strings

(defn read-string [rdr line col]
   (loop [c (.read rdr)
          ln line
          cl (inc col)
          sb (StringBuilder.)]
     (cond (= c -1)
               (list {:tag 'error
                      :type 'unfinished-string
                      :start {:line line :col col}  
                      :end   {:line ln   :col cl }} 
                     c 
                     ln cl)
 
            (= c (int \\))
               (let [c1 (.read rdr)
                     cl (inc cl)]
                 (if (= c1 -1)
                     (list {:tag 'error
                            :type 'unfinished-string
                            :start {:line line :col col}  
                            :end   {:line ln   :col (dec cl) }} 
                           c 
                           ln cl)
                     (do 
                       (.append sb (Character/toString (char c)))
                       (recur 
                           (.read rdr) 
                           ln 
                           (inc cl) 
                           (.append sb (Character/toString (char c1)))))))
             (= c (int \"))
                (list {:tag 'string
                       :lexeme (.toString sb)
                       :start {:line line :col col}  
                       :end   {:line ln   :col cl }} 
                      (.read rdr)  
                      ln (inc cl))
     
             :else (recur 
                       (.read rdr) 
                       ln 
                       (inc cl) 
                       (.append sb (Character/toString (char c)))))))


; Diretivas

(def directive-table
  (hash-map
    "define"     'dir-define
    "endif"      'dir-endif
    "if"         'dir-if
    "ifdef"      'dir-ifdef
    "include"    'dir-include
    "pragma"     'dir-pragma   
))

(defn read-directive [rdr ch line col]
   (loop [c ch
          ln line
          cl col
          sb (StringBuilder.)]
     (cond (Character/isLetter c) 
              (recur (.read rdr) 
                     ln 
                     (inc cl) 
                     (.append sb (Character/toString (char c))))
            :else (let [s (.toString sb)
                         w (directive-table s) ]
                      (if w 
                          (list {:tag w 
                                 :start {:line line :col (dec col)}  
                                 :end   {:line ln   :col (dec cl) }} 
                                c
                                ln cl)
                          (list {:tag 'unknown-directive
                                 :lexeme s 
                                 :start {:line line :col (dec col)}  
                                 :end   {:line ln   :col (dec cl) }} 
                                c 
                                ln cl))))))



(defn token [c nextc line col]
   (list {:tag c
          :start {:line line :col (dec col)}  
          :end   {:line line :col (dec col) }} 
         nextc 
         line col))

(defn token-kwd [kwd nextc len line col]
   (list {:tag kwd
          :start {:line line :col (- col len)}  
          :end   {:line line :col (dec col) }} 
         nextc
         line col))


(defn read-token [rdr c line col]
  (let [[c line col] (skip-spaces-and-comment rdr c line col)] 
     (cond (= c -1) 
              (list {:tag 'EOF :start {:line line :col col}} 
                  c
                  line col)
                  
           (Character/isLetter c) ; Identificador ou palavra reservada         
              (read-keyword-or-id rdr c line col)
           
           (Character/isDigit c)  ; Números
              (read-number rdr c line col)   

           (= c (int \"))  ; Strings
              (read-string rdr line col)

           (#{\( \) \[ \] \{ \} \; \: \, \? \~} (char c)) 
              (token (char c) (.read rdr) line (inc col))

           (= c (int \#))
              (let [ nextc (.read rdr) 
                     cl (inc col) ]
                 (cond (Character/isLetter nextc)  ; diretiva         
                          (read-directive rdr nextc line cl)
                       :else                       ; #
                          (token (char c) nextc line cl)))


           (= c (int \.))
              (let [ nextc (.read rdr) 
                     cl (inc col) ]
                 (cond (= nextc (int \.))             
                          (let [nextc2 (.read rdr)
                                cl (inc cl)]
                             (if (= nextc2 (int \.))     ; ...
                                (token-kwd 'ellipsis (.read rdr) 3 line (inc cl))
                                (do 
                                    (.unread rdr nextc2)  ; .
                                    (token (char c) nextc line (dec cl)))))

                       :else                              ; .
                          (token (char c) nextc line cl)))
                                
                                

           (= c (int \&))
              (let [ nextc (.read rdr) 
                     cl (inc col) ]
                 (cond (= nextc (int \=))             ; &=
                          (token-kwd 'and-assign (.read rdr) 2 line (inc cl))
                       (= nextc (int \&))             ; &&
                          (token-kwd 'and (.read rdr) 2 line (inc cl))   
                       :else                          ; &
                          (token (char c) nextc line cl)))


           (= c (int \|))
              (let [ nextc (.read rdr) 
                     cl (inc col) ]
                 (cond (= nextc (int \=))             ; |=
                          (token-kwd 'or-assign (.read rdr) 2 line (inc cl))
                       (= nextc (int \|))             ; ||
                          (token-kwd 'or (.read rdr) 2 line (inc cl))   
                       :else                          ; |
                          (token (char c) nextc line cl)))

           (= c (int \^))
              (let [ nextc (.read rdr) 
                     cl (inc col) ]
                 (cond (= nextc (int \=))             ; ^=
                          (token-kwd 'xor-assign (.read rdr) 2 line (inc cl))
                       :else                          ; ^
                          (token (char c) nextc line cl)))


           (= c (int \!))
              (let [ nextc (.read rdr) 
                     cl (inc col) ]
                 (cond (= nextc (int \=))             ; !=
                          (token-kwd 'not-equal (.read rdr) 2 line (inc cl))
                       :else                          ; !
                          (token-kwd 'not nextc 1 line cl)))

           (= c (int \+))
              (let [ nextc (.read rdr) 
                     cl (inc col) ]
                 (cond (= nextc (int \+))             ; ++
                          (token-kwd 'inc (.read rdr) 2 line (inc cl))
                       (= nextc (int \=))             ; +=
                          (token-kwd 'add-atrib (.read rdr) 2 line (inc cl))   
                       :else                          ; +
                          (token (char c) nextc line cl)))

           (= c (int \-))
              (let [ nextc (.read rdr) 
                     cl (inc col) ]
                 (cond (= nextc (int \-))             ; --
                          (token-kwd 'dec (.read rdr) 2 line (inc cl))
                       (= nextc (int \>))             ; ->
                          (token-kwd 'ptr (.read rdr) 2 line (inc cl))  
                       (= nextc (int \=))             ; -=
                          (token-kwd 'sub-assign (.read rdr) 2 line (inc cl))   
                       :else                          ; -
                           (token (char c) nextc line cl)))

           (= c (int \/))
              (let [ nextc (.read rdr) 
                     cl (inc col) ]
                 (cond (= nextc (int \=))             ; /=
                          (token-kwd 'div-assign (.read rdr) 2 line (inc cl))
                       :else                          ; /
                          (token (char c) nextc line cl)))

           (= c (int \*))
              (let [ nextc (.read rdr) 
                     cl (inc col) ]
                 (cond (= nextc (int \=))             ; *=
                          (token-kwd 'mul-assign (.read rdr) 2 line (inc cl))
                       :else                          ; *
                          (token (char c) nextc line cl)))

           (= c (int \%))
              (let [ nextc (.read rdr) 
                     cl (inc col) ]
                 (cond (= nextc (int \=))             ; %=
                          (token-kwd 'mod-assign (.read rdr) 2 line (inc cl))
                       :else                          ; %
                          (token (char c) nextc line cl)))


           (= c (int \>))
              (let [ nextc (.read rdr) 
                     cl (inc col) ]
                 (cond (= nextc (int \>))
                          (let [nextc2 (.read rdr)
                                cl (inc cl)]
                             (if (= nextc2 (int \=))                   ; >>=
                                (token-kwd 'sright-assign (.read rdr) 3 line (inc cl))
                                (token-kwd 'sright nextc2 2 line cl))) ; >> 
                       (= nextc (int \=)) ; >=
                          (token-kwd 'ge (.read rdr) 2 line (inc cl))   
                       :else                                           ; >
                          (token (char c) nextc line cl)))

           (= c (int \<))
              (let [ nextc (.read rdr) 
                     cl (inc col) ]
                 (cond (= nextc (int \<))
                          (let [nextc2 (.read rdr)
                                cl (inc cl)]
                             (if (= nextc2 (int \=))
                                (token-kwd 'sleft-assign (.read rdr) 3 line (inc cl))
                                (token-kwd 'sleft nextc2 2 line cl)))   
                       (= nextc (int \=))
                          (token-kwd 'le (.read rdr) 2 line (inc cl))   
                       :else
                          (token (char c) nextc line cl)))



           (= c (int \=))
              (let [ nextc (.read rdr) 
                     cl (inc col) ]
                 (cond (= nextc (int \=))
                          (token-kwd 'equal (.read rdr) 2 line (inc cl))   
                       :else
                           (token (char c) nextc line cl)))
            
           :else   
              (list {:tag 'unknown
                     :lexeme (char c)
                     :start {:line line :col col}  
                     :end   {:line line :col col }} 
                    (.read rdr) 
                    line (inc col)))))


(comment
    Recebe o nome de um arquivo e devolve uma lista de tokens.
    BufferedReader é uma classe do Java que permite que uma sequência de 
caracteres seja armazenada em um buffer cujo tamanho pode ser definido pelo 
usuário. Neste exemplo usamos o tamanho padrão de oito k.
    PushbackReader é uma classe do Java que permite que caracteres sejam observados
e depois retornados ao fluxo de entrada, ou seja, sem consumi-los.    
)

(defn lexer
   "Lexical analyser for the C programming language."
   [reader]
   (with-open [rdr (PushbackReader. (BufferedReader. reader))]
             (loop [c (.read rdr)
                    line 1
                    col  1
                    toks ()]
                (if (not= c -1)
                   (do 
                      (let [[tok nextc line col] (read-token rdr c line col)]
                        (do (println tok)
                         (recur nextc
                                line
                                col
                                (cons tok toks)))))
                   (reverse (cons {:tag 'EOF :start {:line line :col col}} toks))))))
          
(defn lexico 
  "Recebe um nome de arquivo e retorna uma lista de tokens"
  [arquivo]
  (lexer (FileReader. arquivo)))

(defn lexico-str
  "Recebe uma string e retorna uma lista de tokens"
  [cadeia]
  (lexer (StringReader. cadeia)))


(defn teste [cadeia]
  (lexer (PushbackReader. (BufferedReader. (StringReader. cadeia)))))

