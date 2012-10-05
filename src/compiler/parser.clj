(ns compiler.parser
  (:refer-clojure :exclude [==])
  (:use [clojure.core.logic :exclude [is]]
        [clojure.core.logic.dcg] 
        [compiler.lexer :only [lex lex-str]])
  (:use clojure.test)        
)

(defn mensagem [msg expr v]
   (do 
      (println msg)
      (println expr)
      (println v)
      (== 1 1)))


; token
(def-->e tk [tg x]
  ([_ ?tk] [?tk]
     (!dcg
       (project [?tk]
          (== (= (?tk :tag) tg) true)))))

(declare type-name cast-expression unary-expression1 postfix-expression 
         parameter-type-list pointer expression generic-selection 
         struct-or-union-specifier enum-specifier atomic-type-specifier
         direct-abstract-declarator direct-abstract-declarator-opt
         direct-abstract-declarator2 argument-expression-list-opt
         specifier-qualifier-list statement

)

(def-->e eof [tree]
  ([?n] (tk 'EOF ?n)))

(def-->e initializer1 [a1 tree] 
  ([_ a1] (fresh [t1] (tk \} t1)))
  ([_ a1] (fresh [t1 t2] (tk \, t1) (tk \} t2) )))

(def-->e typedef-name [tree]
  ([?n] (tk 'id ?n)))

(def-->e parameter-type-list1 [tree] 
  ([[?n]] (fresh [t1 t2] 
     (tk \, t1) (tk 'ellipsis ?n)))
  ([[]] [])
)

(def-->e function-specifier [tree] 
  ([?n] (fresh [t1] (tk 'inline t1) (!dcg (== ?n {:fn-spec t1} ))))
  ([?n] (fresh [t1] (tk '_Noreturn t1) (!dcg (== ?n {:fn-spec t1} ))))
)

(deftest test-function-specifier-a
   (let [x (lvar 'x)
         ent "inline"
         res (first (run 1 [t r] (function-specifier t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:fn-spec x}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-function-specifier-b
   (let [x (lvar 'x)
         ent "_Noreturn"
         res (first (run 1 [t r] (function-specifier t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:fn-spec x}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(def-->e type-qualifier [tree] 
  ([?n] (fresh [t1] (tk 'const t1)    (!dcg (== ?n {:tp-qual t1} ))))
  ([?n] (fresh [t1] (tk 'restrict t1) (!dcg (== ?n {:tp-qual t1} ))))
  ([?n] (fresh [t1] (tk 'volatile t1) (!dcg (== ?n {:tp-qual t1} ))))
  ([?n] (fresh [t1] (tk '_Atomic t1)  (!dcg (== ?n {:tp-qual t1} ))))
)

(deftest test-type-qualifier-a
   (let [x (lvar 'x)
         ent "const"
         res (first (run 1 [t r] (type-qualifier t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tp-qual x}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-type-qualifier-b
   (let [x (lvar 'x)
         ent "restrict"
         res (first (run 1 [t r] (type-qualifier t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tp-qual x}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-type-qualifier-c
   (let [x (lvar 'x)
         ent "volatile"
         res (first (run 1 [t r] (type-qualifier t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tp-qual x}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-type-qualifier-d
   (let [x (lvar 'x)
         ent "_Atomic"
         res (first (run 1 [t r] (type-qualifier t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tp-qual x}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(def-->e type-qualifier-list1 [tree] 
  ([[?a . ?as]] 
    (type-qualifier ?a) (type-qualifier-list1 ?as) )
  ([[]] []))

(deftest test-type-qualifier-list1-a
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "volatile"
         res (first (run 1 [t r] (type-qualifier-list1 t (lex-str ent) [r] )))
         tree1 (first res)
         stree (lcons {:tp-qual x} y)
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-type-qualifier-list1-b
   (let [x (lvar 'x)
         y (lvar 'y)
         z (lvar 'z)
         ent "volatile _Atomic"
         res (first (run 1 [t r] (type-qualifier-list1 t (lex-str ent) [r] )))
         tree1 (first res)
         stree (lcons {:tp-qual x} (lcons y z))
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)


(def-->e type-qualifier-list [tree] 
  ([[?a . ?as]] 
    (type-qualifier ?a) (type-qualifier-list1 ?as) ))

(deftest test-type-qualifier-list-a
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "const"
         res (first (run 1 [t r] (type-qualifier-list t (lex-str ent) [r] )))
         tree1 (first res)
         stree (lcons {:tp-qual x} y)
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-type-qualifier-list-b
   (let [x (lvar 'x)
         y (lvar 'y)
         z (lvar 'z)
         ent "restrict const volatile _Atomic"
         res (first (run 1 [t r] (type-qualifier-list t (lex-str ent) [r] )))
         tree1 (first res)
         stree (lcons {:tp-qual x} (lcons y z))
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)



(def-->e type-qualifier-list-opt [tree] 
  ([?n] (type-qualifier-list ?n))
  ([[]] []))

(deftest test-type-qualifier-list-opt-a
   (let [x (lvar 'x)
         y (lvar 'y)
         z (lvar 'z)
         ent "restrict const volatile _Atomic"
         res (first (run 1 [t r] (type-qualifier-list-opt t (lex-str ent) [r] )))
         tree1 (first res)
         stree (lcons {:tp-qual x} (lcons y z))
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-type-qualifier-list-opt-b
   (let [x (lvar 'x)
         y (lvar 'y)
         z (lvar 'z)
         ent " "
         res (first (run 1 [t r] (type-qualifier-list-opt t (lex-str ent) [r] )))
         tree1 (first res)
        ]
     (is (empty? tree1) ))
)

(def-->e pointer1 [a1 tree] 
  ([_ ?n] (fresh [a2]
     (pointer a2)
     (!dcg (== ?n {:tag 'pointer :arg1 a1 :arg2 a2}))))
  ([_ ?n] []
     (!dcg (== ?n {:tag 'pointer :arg1 a1 :arg2 'none})))
)

(def-->e pointer [tree] 
  ([?n] (fresh [t1 t2] 
     (tk '* t1) (type-qualifier-list-opt t2) (pointer1 t2 ?n) )))

(deftest test-pointer-a
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "* const"
         res (first (run 1 [t r] (pointer t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'pointer :arg1 a1 :arg2 a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-pointer-b
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "* const *"
         res (first (run 1 [t r] (pointer t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'pointer :arg1 a1 :arg2 a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(def-->e pointer-opt [tree] 
  ([?n] (pointer ?n))
  ([[]] []))

(def-->e enum-specifier1 [a1 tree] 
  ([_ a1] (fresh [t1] (tk \} t1)))
  ([_ a1] (fresh [t1 t2] 
    (tk \, t1) (tk \} t2) )))

(def-->e struct-or-union [tree]
  ([?n] (tk 'struct ?n))
  ([?n] (tk 'union ?n))
) 

(deftest test-struct-or-union-a
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "struct"
         res (first (run 1 [t r] (struct-or-union t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'struct :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-struct-or-union-b
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "union"
         res (first (run 1 [t r] (struct-or-union t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'union :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)


(def-->e storage-class-specifier [tree]
  ([?n] (tk 'typedef ?n))
  ([?n] (tk 'extern ?n))
  ([?n] (tk 'static ?n))
  ([?n] (tk '_Thread_local ?n))
  ([?n] (tk 'auto ?n))
  ([?n] (tk 'register ?n))
)

(deftest test-storage-class-specifier-f
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "register"
         res (first (run 1 [t r] (storage-class-specifier t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'register :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-storage-class-specifier-e
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "auto"
         res (first (run 1 [t r] (storage-class-specifier t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'auto :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-storage-class-specifier-d
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "_Thread_local"
         res (first (run 1 [t r] (storage-class-specifier t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag '_Thread_local :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-storage-class-specifier-c
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "static"
         res (first (run 1 [t r] (storage-class-specifier t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'static :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-storage-class-specifier-b
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "extern"
         res (first (run 1 [t r] (storage-class-specifier t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'extern :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-storage-class-specifier-a
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "typedef"
         res (first (run 1 [t r] (storage-class-specifier t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'typedef :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(def-->e assignment-operator [tree] 
  ([?n] (tk '= ?n))
  ([?n] (tk '*= ?n))
  ([?n] (tk 'div= ?n))
  ([?n] (tk '%= ?n))
  ([?n] (tk '+= ?n))
  ([?n] (tk '-= ?n))
  ([?n] (tk '<<= ?n))
  ([?n] (tk '>>= ?n))
  ([?n] (tk '&= ?n))
  ([?n] (tk 'bxor= ?n))
  ([?n] (tk '|= ?n)))

(deftest test-assignment-operator-a
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "="
         res (first (run 1 [t r] (assignment-operator t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag '= :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-assignment-operator-b
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "*="
         res (first (run 1 [t r] (assignment-operator t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag '*= :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-assignment-operator-c
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "/="
         res (first (run 1 [t r] (assignment-operator t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'div= :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-assignment-operator-d
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "%="
         res (first (run 1 [t r] (assignment-operator t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag '%= :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)
(deftest test-assignment-operator-e
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "+="
         res (first (run 1 [t r] (assignment-operator t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag '+= :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-assignment-operator-f
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "-="
         res (first (run 1 [t r] (assignment-operator t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag '-= :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-assignment-operator-g
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "<<="
         res (first (run 1 [t r] (assignment-operator t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag '<<= :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-assignment-operator-h
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent ">>="
         res (first (run 1 [t r] (assignment-operator t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag '>>= :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-assignment-operator-i
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "&="
         res (first (run 1 [t r] (assignment-operator t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag '&= :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-assignment-operator-j
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "^="
         res (first (run 1 [t r] (assignment-operator t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'bxor= :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-assignment-operator-k
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "|="
         res (first (run 1 [t r] (assignment-operator t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag '|= :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(def-->e unary-operator [tree]
  ([?n] (tk '& ?n))
  ([?n] (tk '* ?n))
  ([?n] (tk '+ ?n))
  ([?n] (tk '- ?n))
  ([?n] (tk 'tilde ?n))
  ([?n] (tk '! ?n))
)

(deftest test-unary-operator-a
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "&"
         res (first (run 1 [t r] (unary-operator t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag '& :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-unary-operator-b
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "*"
         res (first (run 1 [t r] (unary-operator t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag '* :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-unary-operator-c
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "+"
         res (first (run 1 [t r] (unary-operator t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag '+ :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-unary-operator-d
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "-"
         res (first (run 1 [t r] (unary-operator t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag '- :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-unary-operator-e
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "~"
         res (first (run 1 [t r] (unary-operator t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'tilde :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-unary-operator-f
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "!"
         res (first (run 1 [t r] (unary-operator t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag '! :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(def-->e enumeration-constant [tree]
  ([?n] (tk 'id ?n)))

(def-->e constant [tree]
  ([?t] (tk 'int-const ?t))
  ([?t] (tk 'float-const ?t))
  ([?t] (tk 'char-const ?t))
  ([?n] (enumeration-constant ?n))
)

(def-->e primary-expression [tree] 
  ([?n] (tk 'id ?n))
  ([?n] (constant ?n))
  ([?n] (tk 'string ?n))
  ([?n] (fresh [t1,t2] (tk \( t1) (expression ?n) (tk \) t2) ))
  ([?n] (generic-selection ?n)))


(def-->e type-specifier [tree] 
  ([?n] (tk 'void ?n))
  ([?n] (tk 'char ?n))
  ([?n] (tk 'short ?n))
  ([?n] (tk 'int ?n))
  ([?n] (tk 'long ?n))
  ([?n] (tk 'float ?n))
  ([?n] (tk 'double ?n))
  ([?n] (tk 'signed ?n))
  ([?n] (tk 'unsigned ?n))
  ([?n] (tk '_Bool ?n))
  ([?n] (tk '_Complex ?n))
  ([?n] (atomic-type-specifier ?n))
  ([?n] (struct-or-union-specifier ?n))
  ([?n] (enum-specifier ?n))
  ([?n] (typedef-name ?n)))

(deftest test-type-specifier-a
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "void"
         res (first (run 1 [t r] (type-specifier t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'void :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-type-specifier-b
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "char"
         res (first (run 1 [t r] (type-specifier t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'char :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-type-specifier-c
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "short"
         res (first (run 1 [t r] (type-specifier t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'short :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-type-specifier-d
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "int"
         res (first (run 1 [t r] (type-specifier t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'int :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-type-specifier-e
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "long"
         res (first (run 1 [t r] (type-specifier t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'long :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-type-specifier-f
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "float"
         res (first (run 1 [t r] (type-specifier t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'float :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-type-specifier-g
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "double"
         res (first (run 1 [t r] (type-specifier t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'double :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-type-specifier-h
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "signed"
         res (first (run 1 [t r] (type-specifier t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'signed :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-type-specifier-i
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "unsigned"
         res (first (run 1 [t r] (type-specifier t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'unsigned :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-type-specifier-j
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "_Bool"
         res (first (run 1 [t r] (type-specifier t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag '_Bool :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-type-specifier-k
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "_Complex"
         res (first (run 1 [t r] (type-specifier t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag '_Complex :start a1 :end a2}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

; Testes

(def-->e inicio [a1 tree]
  ([_ ?n] (fresh [t1]
      (initializer1 a1 ?n) (eof t1))))

(defn steste [s]
   (run 1 [t] (inicio 'ok t (lex-str s) [])))


(defn steste1 [s]
   (first (first (run 1 [t r] (initializer1 'ok t (lex-str s) [r])))))

(defn resp [l]
   (first (first l)))
      
(deftest test-initializer1
  (testing "Initializer1 falhou!"
    (is (= 'ok 
           (resp (run 1 [t r] 
                   (initializer1 'ok t (lex-str "}") [r])))))
    (is (= 'ok 
           (resp (run 1 [t r] 
                   (initializer1 'ok t (lex-str ", }") [r])))))

))

(deftest test-typedef-name
  (testing "Falha!"
    (is (= 'id
           (:tag
           (resp (run 1 [t r] 
                   (typedef-name t (lex-str "teste") [r]))))))
))

(deftest test-parameter-type-list1
  (testing "Falha!"
    (is (= 'ellipsis
           (:tag
             (first (resp (run 1 [t r] 
                (parameter-type-list1 t (lex-str ", ...") [r])))))))
   (is (empty? (first (resp (run 1 [t r] 
                (parameter-type-list1 t (lex-str " )") [r]))))))
))


(def-->e identifier-opt [tree] 
  ([?n] (tk 'id ?n))
  ([[]] []))


(def-->e specifier-qualifier-list-opt [tree] 
  ([?n] (specifier-qualifier-list ?n))
  ([[]] []))

(def-->e specifier-qualifier-list [tree]
  ([[?t . ?ts]]
      (type-specifier ?t) (specifier-qualifier-list-opt ?ts))
  ([[?t . ?ts]] 
      (type-qualifier ?t) (specifier-qualifier-list-opt ?ts))
  ([[]] [])
)

(deftest test-specifier-qualifier-list-a
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "const volatile restrict _Atomic"
         res (first (run 1 [t r] (specifier-qualifier-list t (lex-str ent) [r] )))
         tree1 (first res)
         stree (lcons {:tp-qual x} y)
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(declare conditional-expression)

(def-->e constant-expression [tree]
  ([?n] []
   (!dcg (== ?n {:const-exp 'FALSO-constant-expression} )))
   ([?n] (conditional-expression ?n)))


(def-->e designator [tree]
   ([?n] 
       (fresh [t1 t2 t3]
         (tk \[ t1) (constant-expression t2) (tk \] t3)
         (!dcg (== ?n {:designator t2} )) ))
   ([?n] (fresh [t1 t2] (tk \. t1) (tk 'id t2)
         (!dcg (== ?n {:designator t2} )) ))
)

(deftest test-designator-a
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent "[]"
         res (first (run 1 [t r] (designator t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:designator a1}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-designator-b
   (let [a1 (lvar 'a1)
         a2 (lvar 'a2)
         ent ". desig1"
         res (first (run 1 [t r] (designator t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:designator a1}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)


(def-->e designator-list1 [tree] 
  ([[?a . ?as]] (fresh [t1] 
     (designator ?a) (designator-list1 ?as) ))
  ([[]] []))


(def-->e designator-list [tree] 
  ([[?a . ?as]]
     (designator ?a) (designator-list1 ?as) ))

(def-->e designation [tree] 
  ([?n] (fresh [t1] (designator-list ?n) (tk '= t1) )))

(def-->e designation-opt [tree] 
  ([?n] (designation ?n))
  ([[]] []))

(declare initializer)

(def-->e initializer-list1 [tree]
  ([[?di . ?il]] 
    (fresh [t1 ?d ?i]
      (tk \, t1) (designation-opt ?d) (initializer ?i) 
      (!dcg (== ?di {:tag 'init :arg1 ?d :arg2 ?i}))
      (initializer-list1 ?il)))
  ([[]] [])
)

(def-->e initializer-list [tree]
  ([[?di . ?il]] 
     (fresh [?d ?i]
       (designation-opt ?d) (initializer ?i) 
       (!dcg (== ?di {:tag 'init :arg1 ?d :arg2 ?i}))
       (initializer-list1 ?il)))
)

(def-->e unary-expression [tree] 
  ([?n] (postfix-expression ?n))
  ([?n] 
     (fresh [t ?u] 
       (tk '++ t) (unary-expression ?u) 
       (!dcg (== ?n {:unop 'inc :arg1 ?u}))))
  ([?n] 
     (fresh [t ?u] 
       (tk '-- t) (unary-expression ?u) 
       (!dcg (== ?n {:unop 'dec :arg1 ?u}))))
  ([?n] 
     (fresh [?u ?c] 
        (unary-operator ?u) (cast-expression ?c) 
        (!dcg 
           (project [?u]
              (== ?n {:unop (?u :tag) :arg1 ?c})))))
  ([?n] (fresh [t1 ?u] 
     (tk 'sizeof t1) (unary-expression1 ?u) 
       (!dcg (== ?n {:unop 'sizeof :arg1 ?u}))))
  ([?n] 
     (fresh [t1 t2 t3 ?tn] 
       (tk '_Alignof t1) (tk \( t2) (type-name ?tn) (tk \) t3)
       (!dcg (== ?n {:unop '_Alignof :arg1 ?tn})))))

(def-->e cast-expression [tree]
  ([?n] (fresh [t1]
     (unary-expression t1)
     (!dcg (== ?n {:tag 'cast-exp :exp t1}))) )
  ([?n] (fresh [t1 t2 ?tn ?ce]
     (tk \( t1) (type-name ?tn) (tk \) t2) (cast-expression ?ce)
       (!dcg (== ?n {:tag 'cast-exp :exp ?ce :type ?tn}))))
)

(def-->e assignment-expression [tree]
  ([?n] (conditional-expression ?n))
  ([?n] 
    (fresh [?a1 ?op ?a2]
      (unary-expression ?a1) (assignment-operator ?op) 
      (assignment-expression ?a2)
      (!dcg 
         (project [?op]
            (== ?n {:tag 'binop :op (?op :tag) :arg1 ?a1 :arg2 ?a2})))))
)

(def-->e initializer [tree] 
  ([?n] (fresh [t1 t2 t3] 
     (tk \{ t1) (initializer-list t2) (initializer1 t2 t3) 
     (!dcg (== ?n {:initializer t3}))))
  ([?n] (fresh [t1] 
     (assignment-expression t1)
     (!dcg (== ?n {:initializer t1}))))
)

(def-->e expression1 [tree]  
  ([[?e . ?es]] (fresh [t1]
     (tk \, t1) (assignment-expression ?e) (expression1 ?es)))
  ([[]] [])
)

(def-->e expression [tree]
  ([[?a . ?as]] 
       (assignment-expression ?a) (expression1 ?as))
)


(deftest test-expression-a
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "1"
         res (first (run 1 [t r] (expression t (lex-str ent) [r] )))
         tree1 (first res)
         stree (lcons {:tag 'cast-exp :exp x} y)
        ]
     (mensagem "expression-a" ent tree1)
     (is (not= (unify empty-s tree1 stree) nil)))
)

(def-->e postfix-expression1 [?pe tree]
  ([_ ?n] (fresh [t1 t2 ?e]
       (tk \[ t1) (expression ?e) (tk \] t2) 
       (postfix-expression1 {:tag 'subs :arg1 ?pe :arg2 ?e} ?n )))
  ([_ ?n] (fresh [t1 t2 ?a]
        (tk \( t1) (argument-expression-list-opt ?a) (tk \) t2) 
        (postfix-expression1 {:tag 'fncall :func ?pe :args ?a} ?n )))
  ([_ ?n] (fresh [t1 t2]
       (tk \. t1) (tk 'id t2)  
       (postfix-expression1 {:tag 'member :arg1 ?pe :arg2 t2} ?n )))
  ([_ ?n] (fresh [t1 t2]
       (tk '-> t1) (tk 'id t2)  
       (postfix-expression1 {:tag 'ptr-member :arg1 ?pe :arg2 t2} ?n )))
  ([_ ?n] (fresh [t1]
       (tk '++ t1)
       (postfix-expression1 {:tag 'post-inc :arg1 ?pe} ?n )))
  ([_ ?n] (fresh [t1]
       (tk '-- t1)
       (postfix-expression1 {:tag 'post-dec :arg1 ?pe} ?n )))
  ([_ ?pe] []))


(def-->e argument-expression-list1 [tree]  
  ([[?a . ?as]] 
    (fresh [t1]
      (tk \, t1) (assignment-expression ?a) (argument-expression-list1 ?as)))
  ([[]] [])
)

(def-->e argument-expression-list [tree]
  ([[?a . ?as]] (assignment-expression ?a) (argument-expression-list1 ?as))
)

(def-->e argument-expression-list-opt [tree] 
  ([?n] (argument-expression-list ?n))
  ([[]] []))

(def-->e postfix-expression2 [a1 tree] 
  ([_ ?n] (fresh [t1] (tk \} t1) (postfix-expression1 a1 ?n) ))
  ([_ ?n] (fresh [t1,t2] (tk \, t1) (tk \} t2) (postfix-expression1 a1 ?n) )))

(def-->e postfix-expression [tree] 
  ([?n] (fresh [t1] 
     (primary-expression t1) (postfix-expression1 t1 ?n) ))
  ([?n] (fresh [t1 t2 t3 t4 t5] 
     (tk \( t1) (type-name t2) (tk \) t3) (tk \{ t4) (initializer-list t5) 
     (postfix-expression2 {:tag 'tipo-init :arg1 t2 :arg2 t5} ?n) ))
)

(deftest test-postfix-expression-a
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "E1[E2]"
         res (first (run 1 [t r] (postfix-expression t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'subs :arg1 x :arg2 y} 
        ]
     (mensagem "postfix-expression-a" ent tree1)
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-postfix-expression-b
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "x[3][5]"
         res (first (run 1 [t r] (postfix-expression t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'subs :arg1 x :arg2 y} 
        ]
     (mensagem "postfix-expression-b" ent tree1)
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-postfix-expression-c
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "(*pf[f1()]) (f2(), f3() + f4())"
         res (first (run 1 [t r] (postfix-expression t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'fncall :func x :args y} 
        ]
     (mensagem "postfix-expression-c" ent tree1)
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-postfix-expression-d
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "f().x"
         res (first (run 1 [t r] (postfix-expression t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'member :arg1 x :arg2 y} 
        ]
     (mensagem "postfix-expression-d" ent tree1)
     (is (not= (unify empty-s tree1 stree) nil)))
)

(def-->e generic-association [tree]
  ([?n] 
     (fresh [t1 ?t ?a]
       (type-name ?t) (tk \: t1) (assignment-expression ?a)
       (!dcg (== ?n {:tag 'gassoc :type ?t :exp ?a}))))
  ([?n] 
     (fresh [t1 t2 ?a]  
       (tk 'default t1) (tk \: t2) (assignment-expression ?a)
       (!dcg (== ?n {:tag 'gassoc :type 'default :exp ?a})))))

(def-->e generic-assoc-list1 [tree]
   ([[?a . ?as]] 
     (fresh [t1]
       (tk \, t1) (generic-association ?a) 
       (generic-assoc-list1 ?as)))
   ([[]] [])
)

(def-->e generic-assoc-list [tree]
   ([[?a . ?as]] (generic-association ?a) (generic-assoc-list1 ?as)))   

(def-->e generic-selection [tree] 
  ([?n] (fresh [t1 t2 t3 t4 ?ae ?gal] 
     (tk '_Generic t1) 
     (tk \( t2) (assignment-expression ?ae) (tk \, t3) 
     (generic-assoc-list ?gal)
     (tk \) t4)
       (!dcg (== ?n {:tag 'gen-sel :exp ?ae :type ?gal})))))

(deftest test-generic-selection-a
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "_Generic((X), long double: cbrtl, default: cbrt, float: cbrtf )"
         res (first (run 1 [t r] (generic-selection t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'gen-sel :exp x :type y}
        ]
     (is (not= (unify empty-s tree1 stree) nil)))
)


(def-->e unary-expression1 [tree] 
  ([?n] (unary-expression ?n))
  ([?n] (fresh [t1,t2] (tk \( t1) (type-name ?n) (tk \) t2) )))

(def-->e multiplicative-expression1 [?a1 tree]
  ([_ ?m] (fresh [t ?a2]
             (tk '* t) (cast-expression ?a2) 
             (multiplicative-expression1 {:tag 'binop :op '* :arg1 ?a1 :arg2 ?a2} ?m)))
  ([_ ?m] (fresh [t ?a2]
             (tk '/ t) (cast-expression ?a2) 
             (multiplicative-expression1 {:tag 'binop :op '/ :arg1 ?a1 :arg2 ?a2} ?m)))
  ([_ ?m] (fresh [t ?a2]
             (tk '% t) (cast-expression ?a2) 
             (multiplicative-expression1 {:tag 'binop :op '% :arg1 ?a1 :arg2 ?a2} ?m)))
  ([_ ?a1] [])
)

(def-->e multiplicative-expression [tree]
  ([?m] (fresh [?c]
          (cast-expression ?c) (multiplicative-expression1 ?c ?m) ))
)

(def-->e additive-expression1 [a1 tree]
  ([_ ?a] (fresh [t ?a2]
             (tk '+ t) (multiplicative-expression ?a2) 
             (additive-expression1 {:tag 'binop :op '+ :arg1 a1 :arg2 ?a2} ?a)))
  ([_ ?a] (fresh [t ?a2]
             (tk '- t) (multiplicative-expression ?a2) 
             (additive-expression1 {:tag 'binop :op '- :arg1 a1 :arg2 ?a2} ?a)))

  ([_ a1] [])
)

(def-->e additive-expression [tree]
  ([?a] (fresh [?m] 
           (multiplicative-expression ?m) (additive-expression1 ?m ?a)))
)

(def-->e shift-expression1 [a1 tree]  
  ([_ ?n] 
     (fresh [t1 ?a2]
       (tk '<< t1) (additive-expression ?a2) 
       (shift-expression1 {:tag 'binop :op '<< :arg1 a1 :arg2 ?a2} ?n)))
  ([_ ?n] 
     (fresh [t1 ?a2]
       (tk '>> t1) (additive-expression ?a2) 
       (shift-expression1 {:tag 'binop :op '>> :arg1 a1 :arg2 ?a2} ?n)))
  ([_ a1] [])
)

(def-->e shift-expression [tree]
  ([?n] 
     (fresh [?a] 
        (additive-expression ?a) (shift-expression1 ?a ?n)))
)


(def-->e relational-expression1 [a1 tree]
  ([_ ?n] 
     (fresh [t1 ?a2]
       (tk '< t1) (shift-expression ?a2)
       (relational-expression1 {:tag 'binop :op '< :arg1 a1 :arg2 ?a2} ?n)))
  ([_ ?n] 
     (fresh [t1 ?a2]
       (tk '> t1) (shift-expression ?a2)
       (relational-expression1 {:tag 'binop :op '> :arg1 a1 :arg2 ?a2} ?n)))
  ([_ ?n] 
     (fresh [t1 ?a2]
       (tk '<= t1) (shift-expression ?a2)
       (relational-expression1 {:tag 'binop :op '<= :arg1 a1 :arg2 ?a2} ?n)))
  ([_ ?n] 
     (fresh [t1 ?a2]
       (tk '>= t1) (shift-expression ?a2)
       (relational-expression1 {:tag 'binop :op '>= :arg1 a1 :arg2 ?a2} ?n)))
  ([_ a1] [])
)

(def-->e relational-expression [tree]
  ([?n] 
     (fresh [?s]
       (shift-expression ?s) (relational-expression1 ?s ?n)))
)

(def-->e equality-expression1 [a1 tree]
  ([_ ?n] 
     (fresh [t1 ?a2]
       (tk '== t1) (relational-expression ?a2) 
       (equality-expression1 {:tag 'binop :op '== :arg1 a1 :arg2 ?a2} ?n)))
  ([_ ?n] 
     (fresh [t1 ?a2]
       (tk '!= t1) (relational-expression ?a2) 
       (equality-expression1 {:tag 'binop :op 'not= :arg1 a1 :arg2 ?a2} ?n)))
  ([_ a1] [])
)

(def-->e equality-expression [tree]
  ([?n] 
     (fresh [?r]
       (relational-expression ?r) (equality-expression1 ?r ?n)))
)

(def-->e AND-expression1 [a1 tree]
  ([_ ?n] 
     (fresh [t1 ?a2]
       (tk '& t1) (equality-expression ?a2) 
       (AND-expression1 {:tag 'binop :op 'bit-and :arg1 a1 :arg2 ?a2} ?n)))
  ([_ a1] [])
)

(def-->e AND-expression [tree]
  ([?n] 
     (fresh [?e]
       (equality-expression ?e) (AND-expression1 ?e ?n)))
)

(def-->e exclusive-OR-expression1 [a1 tree]
  ([_ ?n] 
    (fresh [t1 ?a2]
       (tk \^ t1) (AND-expression ?a2) 
       (exclusive-OR-expression1 {:tag 'binop :op 'bit-xor :arg1 a1 :arg2 ?a2} ?n)))
  ([_ a1] [])
)

(def-->e exclusive-OR-expression [tree]
  ([?n] 
    (fresh [?a1] (AND-expression ?a1) (exclusive-OR-expression1 ?a1 ?n)))
)

(def-->e inclusive-OR-expression1 [a1 tree]
  ([_ ?n] 
      (fresh [t1 ?a2]
        (tk '| t1) (exclusive-OR-expression ?a2) 
        (inclusive-OR-expression1 {:tag 'binop :op 'bit-or :arg1 a1 :arg2 ?a2} ?n)))
  ([_ a1] [])
)

(def-->e inclusive-OR-expression [tree]
  ([?n] 
     (fresh [?a1]
       (exclusive-OR-expression ?a1) (inclusive-OR-expression1 ?a1 ?n)))
)

(def-->e logical-AND-expression1 [a1 tree]
  ([_ ?n] 
     (fresh [t1 ?a2]
       (tk '&& t1) (inclusive-OR-expression  ?a2) 
       (logical-AND-expression1 {:tag 'binop :op 'and :arg1 a1 :arg2 ?a2} ?n)))
  ([_ a1] [])
)

(def-->e logical-AND-expression [tree]
  ([?n] 
    (fresh [?a1]
      (inclusive-OR-expression ?a1) (logical-AND-expression1 ?a1 ?n)))
)

(def-->e logical-OR-expression1 [a1 tree]  
  ([_ ?n] 
      (fresh [t1 ?a2]
         (tk '|| t1) (logical-AND-expression ?a2) 
         (logical-OR-expression1 {:tag 'binop :op 'or :arg1 a1 :arg2 ?a2} ?n)))
  ([_ a1] [])
)

(def-->e logical-OR-expression [tree]
  ([?n] 
    (fresh [?a1] 
      (logical-AND-expression ?a1) (logical-OR-expression1 ?a1 ?n)))
)

(def-->e conditional-expression1 [a1 tree] 
  ([_ ?n] (fresh [t1 ?a2 t3 ?a3] 
     (tk '? t1) (expression ?a2) (tk \: t3) (conditional-expression ?a3) 
     (!dcg 
         (== ?n {:tag 'ternop :op 'if :arg1 a1 :arg2 ?a2 :arg3 ?a3}))))
  ([_ a1] [])
)

(def-->e conditional-expression [tree] 
  ([?n] (fresh [t1] 
     (logical-OR-expression t1) (conditional-expression1 t1 ?n) )))

(def-->e assignment-expression-opt [tree] 
  ([?n] (assignment-expression ?n))
  ([[]] []))

(declare declaration-specifiers)

(def-->e declaration-specifiers-opt [tree] 
  ([?n] (declaration-specifiers ?n))
  ([[]] []))

(def-->e alignment-specifier1 [tree] 
  ([?n] (fresh [t1] (type-name ?n) (tk \) t1) ))
  ([?n] (fresh [t1] (constant-expression ?n) (tk \) t1) )))

(def-->e alignment-specifier [tree] 
  ([?n] (fresh [t1 t2 t3] 
     (tk '_Alignas t1) (tk \( t2) 
     (alignment-specifier1 t3) 
     (!dcg (== ?n {:tag 'alig-spec :arg1 t3})))))

(def-->e declaration-specifiers [tree] 
  ([[?a . ?as]]
     (storage-class-specifier ?a) 
     (declaration-specifiers-opt ?as) )
  ([[?a . ?as]]
     (type-specifier ?a) 
     (declaration-specifiers-opt ?as) )
  ([[?a . ?as]]
     (type-qualifier ?a) 
     (declaration-specifiers-opt ?as) )
  ([[?a . ?as]]
     (function-specifier ?a) 
     (declaration-specifiers-opt ?as) )
  ([[?a . ?as]]
     (alignment-specifier ?a) 
     (declaration-specifiers-opt ?as) ))

(declare abstract-declarator-opt declarator)

(def-->e parameter-declaration1 [a1 tree] 
  ([_ ?n] (fresh [a2] 
     (declarator a2)
     (!dcg (== ?n {:tag 'param-decl :arg1 a1 :arg2 a2}))))
  ([_ ?n]  (fresh [a2] 
     (abstract-declarator-opt a2)
     (!dcg (== ?n {:tag 'param-decl :arg1 a1 :arg2 a2})))))

(def-->e parameter-declaration [tree] 
  ([?n] (fresh [t1] (declaration-specifiers t1) (parameter-declaration1 t1 ?n) )))

(def-->e abstract-declarator [tree] 
  ([?n] (pointer ?n))
  ([?n] (fresh [t1 t2] 
     (pointer-opt t1) (direct-abstract-declarator t2) 
     (!dcg (== ?n {:tag 'abs-decl :arg1 t1 :arg2 t2})))))

(def-->e direct-abstract-declarator [tree] 
  ([?n] (fresh [t1] 
     (direct-abstract-declarator-opt t1) 
     (direct-abstract-declarator2 t1 ?n) ))
  ([?n] (fresh [t1 t2] 
     (tk \( t1) (abstract-declarator ?n) (tk \) t2) )))


(def-->e direct-abstract-declarator-opt [tree] 
  ([?n] (direct-abstract-declarator ?n))
  ([[]] []))

(def-->e direct-abstract-declarator1 [a1 tree] 
  ([_ ?n] (fresh [t1 t2 t3] 
     (type-qualifier-list-opt t1) 
     (assignment-expression-opt t2) (tk \] t3)
     (!dcg (== ?n {:tag 'direct-abs-decl :arg1 a1 :arg2 t1 :arg3 t2}))))
  ([_ ?n] (fresh [t1 t2 t3] 
     (tk 'static t1) (type-qualifier-list-opt t2) 
     (assignment-expression t3) (tk \] ?n)
     (!dcg 
       (== ?n {:tag 'direct-abs-decl-static :arg1 a1 :arg2 t2 :arg3 t3}))))
  ([_ ?n] (fresh [t1 t2 t3] 
     (type-qualifier-list t1) (tk 'static t2) 
     (assignment-expression t3) (tk \] ?n) 
     (!dcg (== ?n {:tag 'direct-abs-decl-static :arg1 a1 :arg2 t1 :arg3 t3}))))
     
  ([_ a1] (fresh [t1 t2] (tk '* t1) (tk \] t2) )))


(def-->e parameter-type-list-opt [tree] 
  ([?n] (parameter-type-list ?n))
  ([[]] []))

(def-->e direct-abstract-declarator2 [a1 tree] 
  ([_ ?n] (fresh [t1] 
     (tk \[ t1) 
     (direct-abstract-declarator1 {:tag 'direct-abs-decl :arg1 a1} ?n)))
  ([_ ?n] (fresh [t1 t2] 
     (tk \( t1) (parameter-type-list-opt t2) (tk \) ?n))))

(def-->e abstract-declarator-opt [tree] 
  ([?n] (abstract-declarator ?n))
  ([[]] []))

(def-->e parameter-list1 [tree] 
  ([[?a . ?as]] (fresh [t1] 
     (tk \, t1) (parameter-declaration ?a) (parameter-list1 ?as) ))
  ([[]] []))

(def-->e parameter-list [tree] 
  ([[?a . ?as]]
     (parameter-declaration ?a) (parameter-list1 ?as) ))

(def-->e parameter-type-list [tree] 
  ([[?a . ?as]] 
     (parameter-list ?a) (parameter-type-list1 ?as) ))

(def-->e identifier-list1 [tree] 
  ([[?a . ?as]] (fresh [t1] 
    (tk \, t1) (tk 'id ?a) (identifier-list1 ?as) ))
  ([[]] []))

(def-->e identifier-list [tree] 
  ([[?a . ?as]] (tk 'id ?a) (identifier-list1 ?as) ))

(def-->e identifier-list-opt [tree] 
  ([?n] (identifier-list ?n))
  ([[]] []))

(declare direct-declarator12)

(def-->e direct-declarator1 [a1 tree] 
  ([_ ?n] (fresh [t1] 
     (tk \[ t1) (direct-declarator12 a1 ?n) ))
  ([_ ?n] (fresh [t1 t2 t3] 
     (tk \( t1) (parameter-type-list t2) (tk \) t3) 
     (direct-declarator1 {:tag 'decl :base a1 :param-type t2} ?n) ))
  ([_ ?n] (fresh [t1,t2,t3] 
     (tk \( t1) (identifier-list-opt t2) (tk \) t3) 
     (direct-declarator1 {:tag 'decl :base a1 :ids t2} ?n) ))
  ([_ a1] []))

(def-->e direct-declarator11 [a1 tree] 
  ([_ ?n] (fresh [t1 t2] 
     (assignment-expression-opt t1) (tk \] t2) 
     (direct-declarator1 {:tag 'decl :base a1 :assign t1} ?n) ))
   ([_ ?n] (fresh [t1 t2] 
     (tk '* t1) (tk \] t2) 
     (direct-declarator1 {:tag 'decl :base [:pointer a1]} ?n) )))

(def-->e direct-declarator12 [a1 tree] 
  ([_ ?n] (fresh [t1] 
     (type-qualifier-list-opt t1) 
     (direct-declarator11 {:tag 'decl :base a1 :ty-qual t1} ?n) ))
  ([_ ?n] (fresh [t1 t2 t3 t4] 
     (tk 'static t1) (type-qualifier-list-opt t2) 
     (assignment-expression t3) (tk \] t4) 
     (direct-declarator1 
        {:tag 'decl :base a1 :ty-qual [:static t2] :assign t3} ?n) ))
  ([_ ?n] (fresh [t1,t2,t3,t4] 
     (type-qualifier-list t1) (tk 'static t2) 
     (assignment-expression t3) (tk \] t4) 
     (direct-declarator1 
        {:tag 'decl :base a1 :ty-qual t1 :assign [:static t3]} ?n) )))

(def-->e direct-declarator [tree] 
  ([?n] (fresh [t1] 
     (tk 'id t1) (direct-declarator1 t1 ?n) ))
  ([?n] (fresh [t1 t2 t3] 
     (tk \( t1) (declarator t2) (tk \) t3) (direct-declarator1 t2 ?n) )))

(def-->e declarator [tree] 
  ([?n] (fresh [t1 t2] 
     (pointer-opt t1) (direct-declarator t2)
     (!dcg (== ?n {:tag 'declarator :arg1 t1 :arg2 t2} ))))
)     

(def-->e declarator-opt [tree] 
  ([?n] (declarator ?n))
  ([[]] []))

(def-->e struct-declarator [tree] 
  ([?n] (declarator ?n))
  ([?n] (fresh [t1 t2 t3] 
     (declarator-opt t1) (tk \: t2) (constant-expression t3)
     (!dcg (== ?n {:tag 'struct-declarator :arg1 t1 :arg2 t2})))))

(def-->e struct-declarator-list1 [tree] 
  ([[?a . ?as]] (fresh [t1] 
     (tk \, t1) (struct-declarator ?a) (struct-declarator-list1 ?as) ))
  ([[]] []))

(def-->e struct-declarator-list [tree] 
  ([[?a . ?as]]
     (struct-declarator ?a) (struct-declarator-list1 ?as) ))
     
(def-->e struct-declarator-list-opt [tree] 
  ([?n] (struct-declarator-list ?n))
  ([[]] []))

(def-->e static-assert-declaration [tree] 
  ([?n] (fresh [t1 t2 t3 t4 t5 t6 t7] 
     (tk '_Static_assert t1) (tk \( t2) (constant-expression t3) (tk \, t4) 
     (tk 'string t5) (tk \) t6) (tk \; t7) 
     (!dcg (== ?n {:tag 'static-assert-dec :arg1 t3 :arg2 t5}))
     )))

(def-->e struct-declaration [tree] 
  ([?n] (fresh [t1 t2 t3] 
     (specifier-qualifier-list t1) (struct-declarator-list-opt t2) (tk \; t3)
     (!dcg (== ?n {:tag 'struct-dec :arg1 t1 :arg2 t2}))))
  ([?n] (static-assert-declaration ?n)))

(def-->e struct-declaration-list1 [tree] 
  ([[?a . ?as]] (struct-declaration ?a) (struct-declaration-list1 ?as))
  ([[]] []))

(def-->e struct-declaration-list [tree] 
  ([[?a . ?as]] (struct-declaration ?a) (struct-declaration-list1 ?as)))

(def-->e struct-or-union-specifier1 [tree] 
  ([?n] (fresh [t1,t2,t3] 
     (identifier-opt t1) (tk \{ t2) (struct-declaration-list t3) (tk \} ?n) 
     (!dcg (== ?n {:tag 'struct-or-union-specifier :arg1 t1 :arg2 t3}))))
  ([?n] (tk 'id ?n)))

(def-->e struct-or-union-specifier [tree] 
  ([?n] (fresh [t1] 
     (struct-or-union t1) (struct-or-union-specifier1 ?n) )))

(def-->e enumerator1 [a1 tree] 
  ([_ ?n] (fresh [t1 t2] 
     (tk '= t1) (constant-expression t2) 
     (!dcg (== ?n {:tag 'enumerator :arg1 a1 :arg2 t2}))))
  ([_ a1] [])
)

(def-->e enumerator [tree] 
  ([?n] (fresh [t1] 
     (enumeration-constant t1) (enumerator1 t1 ?n) )))

(def-->e enumerator-list1 [tree] 
  ([[?a . ?as]] (fresh [t1] 
     (tk \, t1) (enumerator ?a) (enumerator-list1 ?as) ))
  ([[]] []))

(def-->e enumerator-list [tree] 
  ([[?a . ?as]] 
     (enumerator ?a) (enumerator-list1 ?as) ))

(def-->e enum-specifier2 [tree] 
  ([?n] (fresh [t1,t2,t3] 
     (identifier-opt t1) (tk \{ t2) (enumerator-list t3) 
     (enum-specifier1 {:tag 'enum-specifier :arg1 t1 :arg2 t3} ?n) ))
  ([?n] (tk 'id ?n)))

(def-->e enum-specifier [tree] 
  ([?n] (fresh [t1] 
     (tk 'enum t1) (enum-specifier2 ?n) )))

(def-->e type-name [tree] 
  ([?n] (fresh [t1 t2] 
     (specifier-qualifier-list t1) (abstract-declarator-opt t2) 
     (!dcg (== ?n {:tag 'type-name :arg1 t1 :arg2 t2})))))

(def-->e atomic-type-specifier [tree]
  ([?n] (fresh [t1 t2 t3 ?tn]
     (tk '_Atomic t1) (tk \( t2) (type-name ?tn) (tk \) t3)
     (!dcg (== ?n {:tag 'atomic :arg1 ?tn}) )))
)

(def-->e init-declarator1 [a1 tree] 
  ([_ ?n] (fresh [t1 ?a2] 
     (tk '= t1) (initializer ?a2)
     (!dcg 
         (== ?n {:tag 'init-declarator :arg1 a1 :arg2 ?a2}))))
  ([_ a1] [])
)

(def-->e init-declarator [tree] 
  ([?n] (fresh [t1] 
     (declarator t1) (init-declarator1 t1 ?n) )))

(def-->e init-declarator-list1 [tree] 
  ([[?a . ?as]] (fresh [t1] 
     (tk \, t1) (init-declarator ?a) (init-declarator-list1 ?as) ))
  ([[]] []))

(def-->e init-declarator-list [tree] 
  ([[?a . ?as]] 
     (init-declarator ?a) (init-declarator-list1 ?as) ))

(def-->e init-declarator-list-opt [tree] 
  ([?n] (init-declarator-list ?n))
  ([[]] []))

(def-->e declaration [tree] 
  ([?n] (fresh [t1 t2 t3] 
     (declaration-specifiers t1) 
     (init-declarator-list-opt t2) (tk \; t3) 
     (!dcg (== ?n {:tag 'decl :specs t1 :init t2}))))
  ([?n] (fresh [t1]
     (static-assert-declaration t1)
     (!dcg (== ?n {:tag 'decl :assert t1}))))
)

(deftest test-declaration-a
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "int x[3][5];"
         res (first (run 1 [t r] (declaration t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'decl :specs x :init y}
        ]
     (mensagem "declaration-a" ent tree1)   
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-declaration-b
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "const int *ptr_to_constant;"
         res (first (run 1 [t r] (declaration t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'decl :specs x :init y}
        ]
     (mensagem "declaration-b" ent tree1)   
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-declaration-c
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "int *const constant_ptr;"
         res (first (run 1 [t r] (declaration t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'decl :specs x :init y}
        ]
     (mensagem "declaration-c" ent tree1)   
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-declaration-d
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "typedef int *int_ptr;"
         res (first (run 1 [t r] (declaration t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'decl :specs x :init y}
        ]
     (mensagem "declaration-d" ent tree1)   
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-declaration-e
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "const int_ptr constant_ptr;"
         res (first (run 1 [t r] (declaration t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'decl :specs x :init y}
        ]
     (mensagem "declaration-e" ent tree1)   
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-declaration-f
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "float fa[11], *afp[17];"
         res (first (run 1 [t r] (declaration t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'decl :specs x :init y}
        ]
     (mensagem "declaration-f" ent tree1)   
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-declaration-g
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "extern int *x;"
         res (first (run 1 [t r] (declaration t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'decl :specs x :init y}
        ]
     (mensagem "declaration-g" ent tree1)   
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-declaration-h
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "extern int y[];"
         res (first (run 1 [t r] (declaration t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'decl :specs x :init y}
        ]
     (mensagem "declaration-h" ent tree1)   
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-declaration-i
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "int a[n][6][m];"
         res (first (run 1 [t r] (declaration t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'decl :specs x :init y}
        ]
     (mensagem "declaration-i" ent tree1)   
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-declaration-j
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "int (*p)[4][n+1];"
         res (first (run 1 [t r] (declaration t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'decl :specs x :init y}
        ]
     (mensagem "declaration-j" ent tree1)   
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-declaration-k
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "int c[n][n][6][m];"
         res (first (run 1 [t r] (declaration t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'decl :specs x :init y}
        ]
     (mensagem "declaration-k" ent tree1)   
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-declaration-l
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "int (*r)[n][n][n+1];"
         res (first (run 1 [t r] (declaration t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'decl :specs x :init y}
        ]
     (mensagem "declaration-l" ent tree1)   
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-declaration-m
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "void fvla(int m, int C[m][m]);"
         res (first (run 1 [t r] (declaration t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'decl :specs x :init y}
        ]
     (mensagem "declaration-m" ent tree1)   
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-declaration-n
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "int f(void), *fip(), (*pfi)();"
         res (first (run 1 [t r] (declaration t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'decl :specs x :init y}
        ]
     (mensagem "declaration-n" ent tree1)   
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-declaration-o
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "int (*apfi[3])(int *x, int *y);"
         res (first (run 1 [t r] (declaration t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'decl :specs x :init y}
        ]
     (mensagem "declaration-o" ent tree1)   
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-declaration-p
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "int (*fpfi(int (*)(long), int))(int, ...);"
         res (first (run 1 [t r] (declaration t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'decl :specs x :init y}
        ]
     (mensagem "declaration-p"  ent tree1)   
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-declaration-q
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "void addscalar(int n, int m, double a[n][n*m+300], double x);"
         res (first (run 1 [t r] (declaration t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'decl :specs x :init y}
        ]
     (mensagem "declaration-q" ent tree1)   
     (is (not= (unify empty-s tree1 stree) nil)))
)

(deftest test-declaration-r
   (let [x (lvar 'x)
         y (lvar 'y)
         ent "double maximum(int n, int m, double a[*][*]);"
         res (first (run 1 [t r] (declaration t (lex-str ent) [r] )))
         tree1 (first res)
         stree {:tag 'decl :specs x :init y}
        ]
     (mensagem "declaration-r" ent tree1)   
     (is (not= (unify empty-s tree1 stree) nil)))
)



(def-->e declaration-list1 [tree] 
  ([[?a . ?as]] (declaration ?a) (declaration-list1 ?as) )
  ([[]] []))

(def-->e declaration-list [tree] 
  ([[?a . ?as]] (declaration ?a) (declaration-list1 ?as) ))

(def-->e declaration-list-opt [tree] 
  ([?n] (declaration-list ?n))
  ([[]] []))


(def-->e expression-opt [tree] 
  ([?n] (expression ?n))
  ([[]] []))

(def-->e expression-statement [tree] 
  ([?n] (fresh [t1] (expression-opt ?n) (tk \; t1) )))

(def-->e jump-statement [tree] 
  ([?n] (fresh [t1 t2 t3] 
     (tk 'goto t1) (tk 'id t2) (tk \; t3) 
     (!dcg 
         (== ?n {:tag 'jump :name 'goto :label t2}))))
  ([?n] (fresh [t1 t2] 
     (tk 'continue t1) (tk \; t2) 
     (!dcg 
         (== ?n {:tag 'jump :name 'continue}))))  
  ([?n] (fresh [t1 t2] 
     (tk 'break t1) (tk \; t2) 
     (!dcg 
         (== ?n {:tag 'jump :name 'break}))))    
  ([?n] (fresh [t1 t2 t3] 
     (tk 'return t1) (expression-opt t2) (tk \; t3)
     (!dcg 
         (== ?n {:tag 'jump :name 'return}))))  
)
         
(def-->e block-item [tree] 
  ([?n] (fresh [t1] 
    (declaration t1)
    (!dcg 
         (== ?n {:tag 'item :dec t1}))))
  ([?n] (fresh [t1] 
      (statement t1)
      (!dcg 
         (== ?n {:tag 'item :stm t1}))))
)

(def-->e block-item-list1 [tree] 
  ([[?a . ?as]] 
    (block-item ?a) (block-item-list1 ?as))
  ([[]] []))

(def-->e block-item-list [tree] 
  ([[?a . ?as]]
    (block-item ?a) (block-item-list1 ?as) ))

(def-->e block-item-list-opt [tree] 
  ([?n] (block-item-list ?n))
  ([[]] []))

(def-->e iteration-statement1 [tree] 
  ([?n] (fresh [t1 t2 t3 t4 t5 t6 t7] 
     (expression-opt t1) (tk \; t2) (expression-opt t3) 
     (tk \; t4) (expression-opt t5) (tk \) t6) 
     (statement t7)
     (!dcg (== ?n {:tag 'for :init t1 :test t3 :update t5 :body t7})))) 
  ([?n] (fresh [t1 t2 t3 t4 t5 t6] 
     (declaration t1) (expression-opt t2) (tk \; t3) 
     (expression-opt t4) (tk \) t5) 
     (statement t6) 
     (!dcg (== ?n {:tag 'for :decl t1 :init t2 :update t4 :body t6})))) 
)

(def-->e iteration-statement [tree] 
  ([?n] (fresh [t1 t2 t3] 
     (tk 'for t1) (tk \( t2) 
     (iteration-statement1 ?n)))
  ([?n] (fresh [t1 t2 t3 t4 t5] 
     (tk 'while t1) (tk \( t2) (expression t3) (tk \) t4) 
     (statement t5) 
     (!dcg (== ?n {:tag 'while :test t3 :body t5})))) 
  ([?n] (fresh [t1 t2 t3 t4 t5 t6 t7] 
     (tk 'do t1) (statement t2) (tk 'while t3) 
     (tk \( t4) (expression t5) (tk \) t6) (tk \; t7)
     (!dcg (== ?n {:tag 'do-while :test t5 :body t2}))))
)     


(def-->e selection-statement1 [?tes ?th tree] 
  ([_ _ ?n] (fresh [t1 ?el] 
     (tk 'else t1) (statement ?el)
     (!dcg (== ?n {:tag 'if :test ?tes :then ?th :else ?el}))))
  ([_ _ ?n] []
     (!dcg (== ?n {:tag 'if :test ?tes :then ?th})))
)

(def-->e selection-statement [tree]
  ([?n] (fresh [t1 t2 t3 t4 t5] 
     (tk 'if t1) (tk \( t2) (expression t3) (tk \) t4) 
     (statement t5) (selection-statement1 t3 t5 ?n) ))
  ([?n] (fresh [t1 t2 t3 t4 t5] 
     (tk 'switch t1) (tk \( t2) (expression t3) (tk \) t4) 
     (statement t5) 
     (!dcg (== ?n {:tag 'switch :test t3 :body t5}))))
)

(def-->e labeled-statement [tree] 
  ([?n] (fresh [t1 t2 t3] 
     (tk 'id t1) (tk \: t2) (statement t3)
     (!dcg (== ?n {:tag 'labeled :label t1 :body t3}))))
  ([?n] (fresh [t1 t2 t3 t4] 
     (tk 'case t1) (constant-expression t2) (tk \: t3) 
     (statement t4)
     (!dcg (== ?n {:tag 'labeled :exp t2 :body t4}))))     
  ([?n] (fresh [t1 t2 t3] 
     (tk 'default t1) (tk \: t2) 
     (statement t3)
     (!dcg (== ?n {:tag 'labeled :exp 'default :body t3}))))
)


(def-->e compound-statement [tree] 
  ([?n] (fresh [t1 t2 t3] 
     (tk \{ t1) (block-item-list-opt t2) (tk \} t3)
     (!dcg (== ?n {:tag 'comp-stm :body t2}))))
)

(def-->e statement [tree] 
  ([?n] (fresh [t1] 
     (labeled-statement t1)
     (!dcg (== ?n {:tag 'stm :stm t1}))))
  ([?n] (compound-statement ?n))
  ([?n] (fresh [t1] 
     (expression-statement t1)
     (!dcg (== ?n {:tag 'stm :stm t1}))))
  ([?n] (fresh [t1] 
     (selection-statement t1)
     (!dcg (== ?n {:tag 'stm :stm t1}))))
  ([?n] (fresh [t1] 
     (iteration-statement t1)
     (!dcg (== ?n {:tag 'stm :stm t1}))))
  ([?n] (fresh [t1] 
    (jump-statement t1)
    (!dcg (== ?n {:tag 'stm :stm t1}))))
)    

(def-->e function-definition [tree] 
  ([?n] (fresh [t1 t2 t3 t4] 
     (declaration-specifiers t1) (declarator t2) 
     (declaration-list-opt t3) (compound-statement t4)
     (!dcg 
       (== ?n {:tag 'fn-def :type t1 :name t2 :params t3 :body t4}))))
)    

(def-->e external-declaration [tree] 
  ([?n] (fresh [t1] 
     (function-definition t1)
     (!dcg 
       (== ?n {:tag 'ext-dec :dec t1}))))     
  ([?n] (fresh [t1] 
     (declaration t1)
     (!dcg 
       (== ?n {:tag 'ext-dec :dec t1}))))
)

(def-->e translation-unit1 [tree] 
  ([[?a . ?as]]
     (external-declaration ?a) 
     (translation-unit1 ?as))
  ([[]] []))

(def-->e translation-unit [tree] 
  ([[?a . ?as]]
     (external-declaration ?a) 
     (translation-unit1 ?as) ))





















; Impressão

(defn imprime-aux [q]
   (cond (seq? q) (map imprime-aux q)
         (q :binop) 
            (list (q :binop)
               (imprime-aux (q :arg1)) (imprime-aux (q :arg2)))
         (q :unop) 
             (list (q :unop) (imprime-aux (q :arg1)))             
         (q :triop)
            (list (q :triop) 
               (imprime-aux (q :arg1)) (imprime-aux (q :arg2))
               (imprime-aux (q :arg3)))
         :else 
           (case (q :tag) 
              array-sub  (list (imprime-aux (q :arg1)) 
                               (imprime-aux (q :arg2)))
              cexp       (list 'cexp (map :tag (q :type)) 
                               (imprime-aux (q :exp)))
              fncall     (cons ((q :arg1) :lexeme) 
                               (map imprime-aux (q :arg2)))
              id         (symbol (q :lexeme))
              member     (list 'member
                              (imprime-aux (q :arg1)) 
                              (imprime-aux (q :arg2)))
              post-inc   (list 'post-inc (imprime-aux (q :arg1)))
              post-dec   (list 'post-dec (imprime-aux (q :arg1)))                          
              ptr-member (list 'ptrmember
                               (imprime-aux (q :arg1)) 
                               (imprime-aux (q :arg2)))
              string     (q :lexeme)
              int-const  (q :value)
              (q :tag)
           )
        )
)

(defn imprime [q]
   (cond (empty? q) q
          :else 
            (let [tree (first (first q))]
               (imprime-aux tree )  
            ))
)   



