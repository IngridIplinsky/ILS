/* Abstract Syntax Tree based on
1 - https://github.com/xdenser/node-ffiCparser/blob/master/grammar/c.pegjs
2 - https://bitbucket.org/eliben/pycparser */

start
 = TESTE

/*--------------------------------------------------------------*
 *                      A.1 Lexical Grammar                     *
 *--------------------------------------------------------------*/

/****************************************************************
 *                      A.1.1 Lexical elements                  *
 ****************************************************************/

// (6.4) 
token 
=  Keyword
/  identifier
/  constant
/  string_literal
// /  punctuator


SourceCharacter
  = .

WhiteSpace "whitespace"
  = [\t\v\f \u00A0\uFEFF]
  / Zs

// Separator, Space
Zs = [\u0020\u00A0\u1680\u180E\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200A\u202F\u205F\u3000]

LineTerminator
  = [\n\r\u2028\u2029]

LineTerminatorSequence "end of line"
  = "\n"
  / "\r\n"
  / "\r"
  / "\u2028" // line separator
  / "\u2029" // paragraph separator

Comment "comment"
  = MultiLineComment
  / SingleLineComment

MultiLineComment
  = "/*" (!"*/" SourceCharacter)* "*/"

MultiLineCommentNoLineTerminator
  = "/*" (!("*/" / LineTerminator) SourceCharacter)* "*/"

SingleLineComment
  = "//" (!LineTerminator SourceCharacter)*

/* Whitespace */

_
  = (WhiteSpace / MultiLineCommentNoLineTerminator / SingleLineComment)*

__
  = (WhiteSpace / LineTerminatorSequence / Comment)*


/****************************************************************
 *                       A.1.2 Keywords                         *
 ****************************************************************/

AUTO      = t:"auto"      !identifier_part __ { return t; }
BREAK     = t:"break"     !identifier_part __ { return t; }
CASE      = t:"case"      !identifier_part __ { return t; }
CHAR      = t:"char"      !identifier_part __ { return t; }
CONST     = t:"const"     !identifier_part __ { return t; }
CONTINUE  = t:"continue"  !identifier_part __ { return t; }
DEFAULT   = t:"default"   !identifier_part __ { return t; }
DO        = t:"do"        !identifier_part __ { return t; }
DOUBLE    = t:"double"    !identifier_part __ { return t; }
ELSE      = t:"else"      !identifier_part __ { return t; }
ENUM      = t:"enum"      !identifier_part __ { return t; }
EXTERN    = t:"extern"    !identifier_part __ { return t; }
FLOAT     = t:"float"     !identifier_part __ { return t; }
FOR       = t:"for"       !identifier_part __ { return t; }
GOTO      = t:"goto"      !identifier_part __ { return t; }
IF        = t:"if"        !identifier_part __ { return t; }
INLINE    = t:"inline"    !identifier_part __ { return t; }
INT       = t:"int"       !identifier_part __ { return t; }
LONG      = t:"long"      !identifier_part __ { return t; }
REGISTER  = t:"register"  !identifier_part __ { return t; }
RESTRICT  = t:"restrict"  !identifier_part __ { return t; }
RETURN    = t:"return"    !identifier_part __ { return t; }
SHORT     = t:"short"     !identifier_part __ { return t; }
SIGNED    = t:"signed"    !identifier_part __ { return t; }
SIZEOF    = t:"sizeof"    !identifier_part __ { return t; }
STATIC    = t:"static"    !identifier_part __ { return t; }
STRUCT    = t:"struct"    !identifier_part __ { return t; }
SWITCH    = t:"switch"    !identifier_part __ { return t; }
TYPEDEF   = t:"typedef"   !identifier_part __ { return t; }
UNION     = t:"union"     !identifier_part __ { return t; }
UNSIGNED  = t:"unsigned"  !identifier_part __ { return t; }
VOID      = t:"void"      !identifier_part __ { return t; }
VOLATILE  = t:"volatile"  !identifier_part __ { return t; }
WHILE     = t:"while"     !identifier_part __ { return t; }
ALIGNAS   = t:"_Alignas"  !identifier_part __ { return t; }
ALIGNOF   = t:"_Alignof"  !identifier_part __ { return t; }
ATOMIC    = t:"_Atomic"   !identifier_part __ { return t; }
BOOL      = t:"_Bool"     !identifier_part __ { return t; }
COMPLEX   = t:"_Complex"  !identifier_part __ { return t; }
GENERIC   = t:"_Generic"  !identifier_part __ { return t; }
IMAGINARY = t:"_Imaginary" !identifier_part __ { return t; }
NORETURN  = t:"_Noreturn"  !identifier_part __ { return t; }
STATIC_ASSERT 
  = t:"_Static_assert" !identifier_part __ { return t; }
THREAD_LOCAL
  = t:"_Thread_local"  !identifier_part __ { return t; }

Keyword =
( "auto"
/ "break"
/ "case"
/ "char"
/ "const"
/ "continue"
/ "default"
/ "double"
/ "do"
/ "else"
/ "enum"
/ "extern"
/ "float"
/ "for"
/ "goto"
/ "if"
/ "inline"
/ "int"
/ "long"
/ "register"
/ "restrict"
/ "return"
/ "short"
/ "signed"
/ "sizeof"
/ "static"
/ "struct"
/ "switch"
/ "typedef"
/ "union"
/ "unsigned"
/ "void"
/ "volatile"
/ "while"
/ "_Alignas"
/ "_Alignof"
/ "_Atomic"
/ "_Bool"
) !identifier_part

/****************************************************************
 *                     A.1.3 Identifiers                        *
 ****************************************************************/

// (6.4.2.1) 
identifier = 
  !Keyword s:identifier_nondigit ss:identifier_part* __ {
      return { tag: "IDENTIFIER",
               val: s + ss.join("")
             }
  }

identifier_part =
   identifier_nondigit 
/  digit
  
// (6.4.2.1) 
identifier_nondigit
  = nondigit
  / universal_character_name

// (6.4.2.1) 
nondigit
  = [_a-zA-Z]

// (6.4.2.1) 
digit
  = [0-9]

/****************************************************************
 *                A.1.4 Universal character names               *
 ****************************************************************/

// (6.4.3) 
universal_character_name
  = "\\u" u:(hex_quad) { 
      return "\\u" + u.join("") 
  }
  / "\\U" u1:hex_quad u2:hex_quad {
      return "\\U" + u1.join("") + u2.join("")
  }
  
// (6.4.3) 
hex_quad
  = hexadecimal_digit hexadecimal_digit hexadecimal_digit hexadecimal_digit

/****************************************************************  
 *                        A.1.5 Constants                       *
 ****************************************************************/

// (6.4.4) 
constant
  =   floating_constant
  /   integer_constant
  /   enumeration_constant
  /   character_constant

// (6.4.4.1) 
integer_constant "integer constant"
  = n:(decimal_constant / octal_constant / hexadecimal_constant) 
    s:integer_suffix? __ {
      return {
         tag:   "INT_CONST",
         val:  n,
         suffix: s
      } 
  }

// (6.4.4.1) 
decimal_constant
  = d:nonzero_digit ds:digit* {
      return parseInt(d + ds.join(""), 10)
  }

// (6.4.4.1) 
octal_constant
  = "0" num:(octal_digit*) {
      return parseInt("0" + num.join(""), 8)
  }

// (6.4.4.1) 
hexadecimal_constant
  =  hexadecimal_prefix num:(hexadecimal_digit+) {
      return parseInt(num.join(""), 16)
  }

// (6.4.4.1) 
hexadecimal_prefix 
  = "0x" 
  / "0X"

// (6.4.4.1) 
nonzero_digit = [1-9]

// (6.4.4.1) 
octal_digit = [0-7]

// (6.4.4.1) 
hexadecimal_digit = [0-9a-fA-F]

// (6.4.4.1) 
integer_suffix
   = s:((unsigned_suffix (long_long_suffix / long_suffix?))
   / ((long_long_suffix / long_suffix) unsigned_suffix?)) {
     return s.join("")
}
   
// (6.4.4.1) 
unsigned_suffix
  = 'u'i { return "u"; }

// (6.4.4.1) 
long_suffix
  = 'l'i { return "l"; }
  
// (6.4.4.1) 
long_long_suffix
  = ("ll" / "LL") { return "ll"; } 


// (6.4.4.2) 
floating_constant "floating constant"
  = n:( hexadecimal_floating_constant
      / decimal_floating_constant) __ { return n; }

// (6.4.4.2) 
decimal_floating_constant
  = n:( fractional_constant exponent_part?
      / digit_sequence exponent_part) 
    s:floating_suffix? {
    return {
      tag:  "FLOAT_CONST",
      val: parseFloat(n.join("")),
      suffix: s
    }
  }

// (6.4.4.2) 
hexadecimal_floating_constant
  =  hexadecimal_prefix 
     n:(hexadecimal_fractional_constant / hexadecimal_digit_sequence) 
     e:binary_exponent_part s:floating_suffix? {
       return {
         tag:  "FLOAT_CONST",
         val: n * Math.pow(2,e) ,
         suffix: s
       }
  }

// (6.4.4.2) 
fractional_constant
  = d:digit_sequence? "." f:digit_sequence {
      if (d == "")
         return ("0." + f);
      else
         return (d + "." +  f);
  }
  / d:digit_sequence "." {
      return (d + ".0");
  }
   
// (6.4.4.2) 
exponent_part
  = e:[eE] s:sign? d:digit_sequence {
    return (e+s+d)
  }

// (6.4.4.2) 
sign
  = "+"
  / "-"

// (6.4.4.2) 
digit_sequence
  = d:digit+ { return d.join(""); }

// (6.4.4.2) 
hexadecimal_fractional_constant
  = d:hexadecimal_digit_sequence? "." f:hexadecimal_digit_sequence {
      var dec = 0.0;
      if (d != "")
         dec = d.val;
      return dec + f.val / Math.pow(16, f.len);
      
  }
  / d:hexadecimal_digit_sequence "." {
      return d.val;
  }


// (6.4.4.2) 
binary_exponent_part
  = "p"i e:(sign? digit_sequence) {
    return parseInt(e.join(""),10);
   }

// (6.4.4.2) 
hexadecimal_digit_sequence
  = d:hexadecimal_digit+ { 
      var str = d.join("")
      return {len: str.length,
              val: 1.0 * parseInt(str,16)};
    }

// (6.4.4.2) 
floating_suffix
  = "f"i { return "f"; }
  / "l"i { return "l"; }

// (6.4.4.3) 
enumeration_constant
  = identifier

// (6.4.4.4) 
character_constant
  = p:[LuU]? "'" cs:c_char_sequence "'" __ {
    return { tag: "CHAR_CONST",
             val: cs,
             encoding: p
           }
  }

// (6.4.4.4) 
c_char_sequence
  = cs:c_char+ { return cs.join("") }

// (6.4.4.4) 
c_char
  = escape_sequence
  / [^\'\\\n]

// (6.4.4.4) 
escape_sequence
  = universal_character_name
  / hexadecimal_escape_sequence
  / octal_escape_sequence
  / simple_escape_sequence

// (6.4.4.4) 
simple_escape_sequence
  = "\\'" 
  / "\\\"" 
  / "\\?" 
  / "\\\\"
  / "\\a" 
  / "\\b" 
  / "\\f" 
  / "\\n" 
  / "\\r" 
  / "\\t" 
  / "\\v"

// (6.4.4.4) 
octal_escape_sequence
  = o:("\\" octal_digit octal_digit? octal_digit?) {
    return o.join("")
}

// (6.4.4.4) 
hexadecimal_escape_sequence
  = "\\x" h:hexadecimal_digit+ {
     return "\\x" + h.join("")
}

/****************************************************************
 *                     A.1.6 String literals                    *
 ****************************************************************/
 
// (6.4.5) 
string_literal
  = p:encoding_prefix? '"' s:s_char_sequence? '"' __ {
   return { tag: "STRING_LITERAL",
            val: s.join(""),
            encoding: p
          }
}

// (6.4.5) 
encoding_prefix
  = "u8" / "u" / "U" / "L"

// (6.4.5) 
s_char_sequence 
  = s_char+

// (6.4.5) 
s_char
  = escape_sequence
  / [^"\\\n]

/****************************************************************
 *                       A.1.7 Punctuators                      *
 ****************************************************************/

LBRK   = s:"["  __ { return s; }
RBRK   = s:"]"  __ { return s; }
LPAR   = s:"("  __ { return s; }
RPAR   = s:")"  __ { return s; }
LWING  = s:"{"  __ { return s; }
RWING  = s:"}"  __ { return s; }
DOT    = s:"."  __ { return s; }
PTR    = s:"->" __ { return s; }
INC    = s:"++" __ { return s; }
DEC    = s:"--" __ { return s; }
BAND   = s:"&" ![&] __ { return s; }
STAR   = s:"*" ![=] __ { return s; }
PLUS   = s:"+" ![+=] __ { return s; }
MINUS  = s:"-" ![\-=>]__ { return s; }
TILDE  = s:"~" __ { return s; }
BANG   = s:"!" ![=] __ { return s; }
DIV    = s:"/" ![=] __ { return s; }
MOD    = s:"%" ![=>] __ { return s; }
SLEFT  = s:"<<" ![=] __ { return s; }
SRIGHT = s:">>" ![=] __ { return s; }
LT     = s:"<" ![=] __ { return s; }
GT     = s:">" ![=] __ { return s; }
LEQ    = s:"<=" __ { return s; }
GEQ    = s:">=" __ { return s; }
EQUAL  = s:"==" __ { return s; }
DIFF   = s:"!=" __ { return s; }
BXOR   = s:"^" ![=] __ { return s; }
BOR    = s:"|" ![=] __ { return s; }
AND    = s:"&&" __ { return s; }
OR     = s:"||" __ { return s; }
QUERY  = s:"?" __ { return s; }
COLON  = s:":" ![>] __ { return s; }
SEMI   = s:";" __ { return s; }
ELLIPSIS    = s:"..." __ { return "ELLIPSIS"; }
ATRIB       = s:"=" !"=" __ { return s; }
STARATRIB   = s:"*=" __ { return s; }
DIVATRIB    = s:"/=" __ { return s; }
MODATRIB    = s:"%=" __ { return s; }
PLUSATRIB   = s:"+=" __ { return s; }
MINUSATRIB  = s:"-=" __ { return s; }
SLEFTATRIB  = s:"<<=" __ { return s; }
SRIGHTATRIB = s:">>=" __ { return s; }
BANDATRIB   = s:"&=" __ { return s; }
BXORATRIB   = s:"^=" __ { return s; }
BORATRIB    = s:"|=" __ { return s; }
COMMA       = s:"," __ { return s; }
SHARP       = s:"#" ![#] WhiteSpace* { return "SHARP"; }
DOUBLESHARP = s:"##" WhiteSpace* { return "DSHARP"; }

EOT = !. 


/****************************************************************
 *                      A.1.8 Header names                      *
 ****************************************************************/
// (6.4.7) 
header_name
=   LT n:h_char_sequence ">"  WhiteSpace* { 
       return { file: n,
                system: true };
       }
/   '"' n:q_char_sequence '"' WhiteSpace* {
        return { file: n,
                 system: false };
       }

// (6.4.7) 
h_char_sequence = hs:h_char+ { return hs.join(""); }

//(6.4.7) any member of the source character set except the new-line character and >
h_char = !(new_line / ">") c:SourceCharacter { return c; }
   
// (6.4.7) 
q_char_sequence = qs:q_char+  { return qs.join(""); }

// (6.4.7) any member of the source character set except the new-line character and "
q_char = !(new_line / '"') c:SourceCharacter  { return c; }

new_line = LineTerminatorSequence

/*--------------------------------------------------------------*
 *                   A.2 Phrase structure grammar               *
 *--------------------------------------------------------------*/

/****************************************************************
 *                        A.2.1 Expressions                     *
 ****************************************************************/

// (6.5.1) 
primary_expression
=  identifier
/  constant
/  string_literal
/  LPAR expr:expression RPAR { return expr; }
/  generic_selection

// (6.5.1.1) 
generic_selection
=  GENERIC LPAR cond:assignment_expression COMMA
   list:generic_assoc_list RPAR {
   return {
     tag: "GenericSelection",
     test: cond,
     list: list
   };
}

// (6.5.1.1) 
generic_assoc_list =  
   hd:generic_association 
   tl:(COMMA ga:generic_association { return ga; })* {
      return [hd].concat(tl);
   }

// (6.5.1.1) 
generic_association
  = cond:(type_name / DEFAULT) COLON stm:assignment_expression {
  return {
    test: cond,
    stm: stm
  };
}  

// (6.5.2) 
postfix_expression =
  hd:postfix_expression_head tl:postfix_expression_tail* {
   var result = hd;
   for (var i = 0; i < tl.length; i++) 
     switch (tl[i].tag) {
       case "ArraySub":
         result = {
           tag: "ArrayRef",
           name: result,
           subscript: tl[i].sub
         };
         break;
       case "FnArgs":
         result = {
           tag: "FnCall",
           name: result,
           args: tl[i].args
         };
         break;
       case "StructField":
         result = {
           tag: "StructRef",
           name: result,
           type: tl[i].type,
           field: tl[i].field
         };
         break;
       case "UnOp":
         result = {
           tag: "PostExp",
           val: result,
           operator: tl[i].operator
         };
         break;
       default:
         throw new Error("Invalid expression type: " + tl.tag);
         
     }     
   return result;
} 

postfix_expression_head =   
  LPAR type:type_name RPAR LWING init:initializer_list COMMA?  RWING {
  return {
    tag: "CompoundLiteral",
    type: type, 
    init: init
  };
}    
/  primary_expression

postfix_expression_tail =
  LBRK sub:expression RBRK {
    return {
      tag: "ArraySub",
      sub: sub
    };
  }
/ LPAR args:argument_expression_list? RPAR {
    return {
      tag: "FnArgs",
      args: (args) ? args : []
    };
  }
/ type:(DOT / PTR) args:identifier {
    return {
      tag: "StructField",
      type: type,
      field: args
    };
  }
/ op:( INC / DEC ) {
    return {
      tag: "UnOp",
      operator: op
    };
  }

// (6.5.2) 
argument_expression_list =
  hd:assignment_expression 
  tl:( COMMA ae:assignment_expression { return ae; })* {
      return [hd].concat(tl);
  }


// (6.5.3) 
unary_expression =
   postfix_expression
/  op:( INC / DEC) expr:unary_expression {
     return {tag: "UnExp",
             operator: op,
             expr: expr
            };
   }
/  op:unary_operator expr:cast_expression {
     return {tag: "UnExp",
             operator: op,
             expr: expr
            };
   }
/  op:SIZEOF LPAR expr:type_name RPAR {
     return {tag: "UnExp",
             operator: op,
             expr: expr
            };
   }
/  op:SIZEOF expr:unary_expression {
     return {tag: "UnExp",
             operator: op,
             expr: expr
            };
   }
/  op:ALIGNOF LPAR expr:type_name RPAR {
     return {tag: "UnExp",
             operator: op,
             expr: expr
            };
   }


// (6.5.3) 
unary_operator =
  MINUS
/ BAND
/ STAR
/ PLUS
/ TILDE
/ BANG  

// (6.5.4) 
cast_expression =
   unary_expression
/  LPAR type:type_name RPAR expr:cast_expression {
     return {tag: "CastExp",
             type: type,
             expr: expr
            };
   }


// (6.5.5)
multiplicative_expression =
   hd:cast_expression tl:multiplicative_expression_tail* {
   var result = hd;
   for (var i = 0; i < tl.length; i++) {
     result = {
       tag:     "BinExp",
       operator: tl[i][0],
       left:     result,
       right:    tl[i][1]
     };
   }
   return result;
} 


multiplicative_expression_tail =   
   (STAR / DIV / MOD ) cast_expression

// (6.5.6)
additive_expression =
   hd:multiplicative_expression tl:additive_expression_tail* {
   var result = hd;
   for (var i = 0; i < tl.length; i++) {
     result = {
       tag:     "BinExp",
       operator: tl[i][0],
       left:     result,
       right:    tl[i][1]
     };
   }
   return result;
} 
  
additive_expression_tail =   
   ( MINUS / PLUS ) multiplicative_expression


// (6.5.7) 
shift_expression =
   hd:additive_expression tl:shift_expression_tail* {
   var result = hd;
   for (var i = 0; i < tl.length; i++) {
     result = {
       tag:     "BinExp",
       operator: tl[i][0],
       left:     result,
       right:    tl[i][1]
     };
   }
   return result;
} 

shift_expression_tail =   
   SLEFT additive_expression
/  SRIGHT additive_expression
   
   
// (6.5.8)
relational_expression =
   hd:shift_expression tl:relational_expression_tail* {
   var result = hd;
   for (var i = 0; i < tl.length; i++) {
     result = {
       tag:     "BinExp",
       operator: tl[i][0],
       left:     result,
       right:    tl[i][1]
     };
   }
   return result;
} 

relational_expression_tail =   
  ( LT / GT / LEQ / GEQ ) shift_expression


// (6.5.9) 
equality_expression =
   hd:relational_expression tl:equality_expression_tail* {
   var result = hd;
   for (var i = 0; i < tl.length; i++) {
     result = {
       tag:     "BinExp",
       operator: tl[i][0],
       left:     result,
       right:    tl[i][1]
     };
   }
   return result;
} 
   
equality_expression_tail =   
   ( EQUAL / DIFF) relational_expression
   

// (6.5.10)
AND_expression =
   hd:equality_expression tl:AND_expression_tail* {
   var result = hd;
   for (var i = 0; i < tl.length; i++) {
     result = {
       tag:     "BinExp",
       operator: tl[i][0],
       left:     result,
       right:    tl[i][1]
     };
   }
   return result;
} 

AND_expression_tail =   
   BAND equality_expression

// (6.5.11)
exclusive_OR_expression =
   hd:AND_expression tl:exclusive_OR_expression_tail* {
   var result = hd;
   for (var i = 0; i < tl.length; i++) {
     result = {
       tag:     "BinExp",
       operator: tl[i][0],
       left:     result,
       right:    tl[i][1]
     };
   }
   return result;
} 

exclusive_OR_expression_tail =
   BXOR AND_expression

// (6.5.12)
inclusive_OR_expression = 
   hd:exclusive_OR_expression tl:inclusive_OR_expression_tail* {
   var result = hd;
   for (var i = 0; i < tl.length; i++) {
     result = {
       tag:     "BinExp",
       operator: tl[i][0],
       left:     result,
       right:    tl[i][1]
     };
   }
   return result;
} 

inclusive_OR_expression_tail =   
   BOR exclusive_OR_expression 
   
// (6.5.13)
logical_AND_expression = 
   hd:inclusive_OR_expression tl:logical_AND_expression_tail* {
   var result = hd;
   for (var i = 0; i < tl.length; i++) {
     result = {
       tag:     "BinExp",
       operator: tl[i][0],
       left:     result,
       right:    tl[i][1]
     };
   }
   return result;
} 

logical_AND_expression_tail =   
   AND inclusive_OR_expression


// (6.5.14)
logical_OR_expression =
   hd:logical_AND_expression tl:logical_OR_expression_tail* {
   var result = hd;
   for (var i = 0; i < tl.length; i++) {
     result = {
       tag:     "BinExp",
       operator: tl[i][0],
       left:     result,
       right:    tl[i][1]
     };
   }
   return result;
} 

logical_OR_expression_tail =   
   OR logical_AND_expression

// (6.5.15) 
conditional_expression =
   cond:logical_OR_expression QUERY tExp:expression COLON fExp:conditional_expression {
      return {
        tag:            "CondExp",
        test:       cond,
        trueExpression:  tExp,
        falseExpression: fExp
      };
    }
/  logical_OR_expression   
   
// (6.5.16) 
assignment_expression =
   left:unary_expression op:assignment_operator right:assignment_expression {
      var r = {};
      switch (op) {
        case "*=":
             r = {
                tag: 'BinExp',
                operator: '*',
                left: left,
                right: right
             };
             break;
        case "/=":
             r = {
                tag: 'BinExp',
                operator: '/',
                left: left,
                right: right
             };
             break;
        case "%=":
             r = {
                tag: 'BinExp',
                operator: '%',
                left: left,
                right: right
             };
             break;
        case "+=":
             r = {
                tag: 'BinExp',
                operator: '+',
                left: left,
                right: right
             };
             break;
        case "-=":
             r = {
                tag: 'BinExp',
                operator: '-',
                left: left,
                right: right
             };
             break;
        case "<<=":
             r = {
                tag: 'BinExp',
                operator: '<<',
                left: left,
                right: right
             };
             break;
        case ">>=":
             r = {
                tag: 'BinExp',
                operator: '>>',
                left: left,
                right: right
             };
             break;
        case "&=":
             r = {
                tag: 'BinExp',
                operator: '&',
                left: left,
                right: right
             };
             break;
        case "^=":
             r = {
                tag: 'BinExp',
                operator: '^',
                left: left,
                right: right
             };
             break;
        case "|=":
             r = {
                tag: 'BinExp',
                operator: '|',
                left: left,
                right: right
             };
             break;
        default:
             r = right;
      }
      
      return {
        tag:     "AssignExp",
        left:     left,
        right:    r
      };
    }
/  conditional_expression

// (6.5.16) 
assignment_operator =
   ATRIB
/  STARATRIB 
/  DIVATRIB 
/  MODATRIB 
/  PLUSATRIB 
/  MINUSATRIB
/  SLEFTATRIB
/  SRIGHTATRIB
/  BANDATRIB 
/  BXORATRIB 
/  BORATRIB
   
// (6.5.17)
expression =
   hd:assignment_expression 
   tl:(COMMA ae:assignment_expression { return ae; })* {
      return [hd].concat(tl);
    }

// (6.6) 
constant_expression =
   conditional_expression


/****************************************************************
 * A.2.2 Declarations                                           *
 ****************************************************************/


// (6.7) 
declaration =
   ds:declaration_specifiers idl:init_declarator_list? SEMI {
     var res = idl? idl : [[]];
     return res.map(function(x) { return x.concat(ds);});
   }
/  static_assert_declaration

// (6.7) 
declaration_specifiers =
   hd:( storage_class_specifier
      / type_qualifier
      / function_specifier
      / alignment_specifier
      )*
   tp: typedef_name 
   tl:( storage_class_specifier
      / type_qualifier
      / function_specifier
      / alignment_specifier
      )* { 
        return (hd.concat(tp,tl)).reverse();
   }
/  ds:( storage_class_specifier
      / type_specifier
      / type_qualifier
      / function_specifier
      / alignment_specifier
      )+ {
        return ds.reverse();
      }

// (6.7) 
init_declarator_list =
   hd:init_declarator tl:(COMMA id:init_declarator { return id; } )* {
      return [hd].concat(tl);
    }

// (6.7) 
init_declarator =
   d:declarator init:(ATRIB i:initializer { return i; } )? {
      return d.concat(init? {tag:'init', val: init} : []);
   }

// (6.7.1) 
storage_class_specifier =
tp:(  TYPEDEF
   /  EXTERN
   /  STATIC
   /  THREAD_LOCAL
   /  AUTO
   /  REGISTER
   ) {
      return { 
        tag: tp,
        type: 'none'
      };
}

// (6.7.2) 
type_specifier =
tp:( VOID
   / CHAR
   / SHORT
   / INT
   / LONG
   / FLOAT
   / DOUBLE
   / SIGNED
   / UNSIGNED
   / BOOL
   / COMPLEX 
   ) {
        return {
          tag:  tp,
          type: 'none', 
        };
   }
   /  atomic_type_specifier
   /  tp:struct_or_union_specifier {
        return tp;
   }
   /  es:enum_specifier {
        return { 
          tree: {tag: 'type_specifier',
                 cld: [es.tree] }
        };
   }

// (6.7.2.1) 
struct_or_union_specifier =
   su:struct_or_union id:identifier? 
   LWING sdl:struct_declaration_list RWING {
     return { tag: su,
              name: id? id : 'none',
              fields: sdl
            };
              
   }
/  su:struct_or_union id:identifier {
     return { tag: su,
              name: id,
              fields: []
            };
              
   }

// (6.7.2.1) 
struct_or_union =
  su:( STRUCT
     / UNION ) {
   return su;
}

// (6.7.2.1) 
struct_declaration_list =
   sdl:struct_declaration+ {
     var merged = [];
     return merged.concat.apply(merged, sdl);
   }

// (6.7.2.1) 
struct_declaration =
   sql:specifier_qualifier_list sdl:struct_declarator_list? SEMI {
     var res = sdl? sdl : [[]];
     return res.map(function(x) { return x.concat(sql);});   
   }   
/  sad:static_assert_declaration {
      return { tree: { tag: "struct_declaration",
                       cld: [sad.tree] }
     };
   }
   
// (6.7.2.1) 
specifier_qualifier_list =
   sql:(type_specifier / type_qualifier)+ {
      return sql;
   }

// (6.7.2.1)
struct_declarator_list =
   hd:struct_declarator 
   tl:(COMMA sd:struct_declarator { return sd; })* {
      return [hd].concat(tl);
   }

// (6.7.2.1) 
struct_declarator =
   d:declarator? COLON c:constant_expression {
     return { tree: { tag: "struct_declarator",
                      cld: [ d? d.tree : 'none', c]} 
     };
   }
/  declarator

// (6.7.2.2) 
enum_specifier =
   ENUM id:identifier? LWING el:enumerator_list COMMA? RWING {
     return {tree: { tag: "enum_specifier",
                     cld: [id? id : 'none', el.tree] }
     };
   }
/  ENUM id:identifier {
     return {tree: { tag: "enum_specifier",
                     cld: [id? id : 'none'] }
     };
   }

// (6.7.2.2) 
enumerator_list =
   hd:enumerator tl:(COMMA t:enumerator {return t;})* {
     return { tree: {tag: "enumerator_list",
                     cld: [hd.tree].concat(tl.map(function(x) { return x.tree;})) }
     };
   }

// (6.7.2.2) 
enumerator =
   ec:enumeration_constant ce:(ATRIB c:constant_expression {return c;})? {
    return { tree: {tag: 'enumerator', 
                    cld: [ec, ce ? ce : 'none']}
    };
   }

// (6.7.2.4) 
atomic_type_specifier =
   ATOMIC LPAR type_name RPAR

// (6.7.3) 
type_qualifier =
 tq:( CONST
    /  RESTRICT
    /  VOLATILE
    /  ATOMIC) {
      return { tag: tq,
               type: 'none'
             };
    }  

// (6.7.4) 
function_specifier =
   INLINE
/  NORETURN

// (6.7.5) 
alignment_specifier = 
   ALIGNAS LPAR (type_name / constant_expression) RPAR 

// (6.7.6) 
declarator =
   ptr:pointer? dec:direct_declarator {
     return dec.concat(ptr? ptr : []);
}


// (6.7.6) 
direct_declarator =
   hd:direct_declarator_head tl:direct_declarator_tail* {         
      return hd.concat(tl);
   } 

direct_declarator_head =   
   id:identifier { 
     return [{ tag: 'HEAD', val: id }];
   }
/  LPAR d:declarator RPAR {
     return d;
}

direct_declarator_tail = 
   LBRK tql:type_qualifier_list? e:assignment_expression? RBRK {
     return {tag: 'ARRAY',
             type: tql? tql : [], 
             size: e? e : 'none'};     
   }
/  LBRK STATIC tql:type_qualifier_list? e:assignment_expression RBRK {
     return {
        tree: { tag: "direct_declarator_tail",
                num: 2,
                cld: [tql ? tql.tree : 'none',
                      e]}
     };
   }
/  LBRK tql:type_qualifier_list STATIC e:assignment_expression RBRK {
     return {
        tree: { tag: "direct_declarator_tail",
                num: 3,
                cld: [tql.tree, e]}
     };
   }
/  LBRK tql:type_qualifier_list? STAR RBRK {
     return {
        tree: { tag: "direct_declarator_tail",
                num: 4,
                cld: [tql.tree]}
     };
   }
/  LPAR ptl:parameter_type_list RPAR {
     return {tag: 'params', 
             val: ptl.val, 
             vararg: ptl.vararg};
   }
/  LPAR idl:identifier_list? RPAR {
     return {tag: 'params', 
             val: idl? idl : [], 
             vararg: false};
   }

// (6.7.6) 
pointer = 
   STAR tql:type_qualifier_list? ptr:pointer? {
     var res = [{ tag: 'POINTER', type: 'none'}].concat(tql? tql: [], 
                                                        ptr? ptr : []);
     return res;
   }



// (6.7.6) 
type_qualifier_list =
   tql:type_qualifier+ {
     var res = tql[0];
     for(var i=1; i < tql.length; i++){
       tql[i].type = res;
       res = tql[i];
     }   
     return res;
   }

// (6.7.6) 
parameter_type_list =
   pl:parameter_list vararg:( COMMA ELLIPSIS )? {
      var res = { 
        val: pl,
        vararg: vararg ? true : false };
      return res ;
   }

// (6.7.6) 
parameter_list =
   hd:parameter_declaration 
   tl:( COMMA p:parameter_declaration { return p; } )* {
     return [hd].concat(tl);
   }

// (6.7.6) 
parameter_declaration =
   sps:declaration_specifiers 
   dec:( declarator / abstract_declarator? ) {
     var res = dec ? dec : [];
     return res.concat(sps);
   }

// (6.7.6) 
identifier_list =
   id:identifier idl:( COMMA id:identifier { return id; } )* {
     return [id].concat(idl);
   }

// (6.7.7) 
type_name =
   sql:specifier_qualifier_list ad:abstract_declarator? {
     return sql.concat(ad? ad : []);
   }

// (6.7.7) 
abstract_declarator =
   ptr:pointer? dad:direct_abstract_declarator {
     return { tree: {tag: "abstract_declarator",
                     cld: [ptr? ptr.tree : 'none', dad.tree]}
     };
   }
/  pointer

// (6.7.7) 
direct_abstract_declarator =
   hd:direct_abstract_declarator_head
   tl:direct_abstract_declarator_tail* {
      return { tree: {tag: "direct_abstract_declarator",
                      cld: [hd.tree].concat(tl.map(function(x) { return x.tree;}))}
      };
   }
    
direct_abstract_declarator_head =
   LPAR ad:abstract_declarator RPAR {
     return { tree: {tag: "abstract_declarator_head",
                     num: 1,
                     cld: [ad.tree]}
     };
   }
/  LBRK tql:type_qualifier_list? e:assignment_expression? RBRK {
     return { tree: {tag: "abstract_declarator_head",
                     num: 2,
                     cld: [tql? tql.tree : 'none',
                           e? e : 'none']}
     };
   }
/  LBRK STATIC tql:type_qualifier_list? e:assignment_expression RBRK {
     return { tree: {tag: "abstract_declarator_head",
                     num: 3,
                     cld: [tql? tql.tree : 'none',
                           e]}
     };
   }
/  LBRK tql:type_qualifier_list STATIC e:assignment_expression RBRK {
     return { tree: {tag: "abstract_declarator_head",
                     num: 4,
                     cld: [tql.tree, e]}
     };
   }
/  LBRK STAR RBRK {
     return { tree: {tag: "abstract_declarator_head",
                     num: 5,
                     cld: []}
     };
   }
/  LPAR ptl:parameter_type_list? RPAR  {
     return { tree: {tag: "abstract_declarator_head",
                     num: 6,
                     cld: [ptl? ptl.tree: 'none']}
     };
   }


direct_abstract_declarator_tail =
   LBRK tql:type_qualifier_list? e:assignment_expression? RBRK {
     return { tree: {tag: "abstract_declarator_tail",
                     num: 1,
                     cld: [tql? tql.tree : 'none',
                           e? e : 'none']}
     };
   }
/  LBRK STATIC tql:type_qualifier_list? e:assignment_expression RBRK {
     return { tree: {tag: "abstract_declarator_tail",
                     num: 2,
                     cld: [tql? tql.tree : 'none',
                           e]}
     };
   }
/  LBRK tql:type_qualifier_list STATIC e:assignment_expression RBRK {
     return { tree: {tag: "abstract_declarator_tail",
                     num: 3,
                     cld: [tql.tree, e]}
     };
   }
/  LBRK STAR RBRK {
     return { tree: {tag: "abstract_declarator_tail",
                     num: 4,
                     cld: []}
     };
   }
/  LPAR ptl:parameter_type_list? RPAR {
     return { tree: {tag: "abstract_declarator_tail",
                     num: 5,
                     cld: [ptl? ptl.tree : 'none']}
     };
   }


// (6.7.8) 
typedef_name =
   identifier

// (6.7.9) 
initializer =
    e:assignment_expression 
/   LWING il:initializer_list COMMA? RWING {
      return il;
    }

// (6.7.9) TODO: designation nao foi tratado !!!!
initializer_list =
   d:designation? hd:initializer 
   tl:( COMMA designation? i:initializer { return i; })* {
     return [hd].concat(tl);
   }

// (6.7.9) 
designation =
   designator_list ATRIB 

// (6.7.9) 
designator_list =
   designator+

// (6.7.9) 
designator =
   LBRK constant_expression RBRK 
/  DOT identifier

// (6.7.10) 
static_assert_declaration =
   STATIC_ASSERT LPAR constant_expression COMMA string_literal RPAR SEMI 

/****************************************************************
 * A.2.3 Statements                *
 ****************************************************************/
 
// (6.8) 
statement =
    labeled_statement
/   compound_statement
/   expression_statement
/   selection_statement
/   iteration_statement
/   jump_statement

// (6.8.1) 
labeled_statement =
    identifier COLON statement
/   CASE constant_expression COLON statement
/   DEFAULT COLON statement

// (6.8.2) 
compound_statement =
   LWING bil:block_item_list? RWING { 
     return {
       tag:'CompStm',
       val: bil? bil : [] 
     };
   }
// (6.8.2) 
block_item_list =
   block_item+

// (6.8.2) 
block_item =
   dec:declaration
/  statement

// (6.8.3) 
expression_statement =
   expr:expression? SEMI {
     return {
       tag: 'ExprStm',
       val: expr? expr : 'none'
     };
   }

// (6.8.4) 
selection_statement =
   stm:IF LPAR exp1:expression RPAR 
       tPart:statement 
       ePart:(ELSE s:statement { return s; })? {
     return {
       tag: 'IfStm',
       test: exp1,
       then: tPart,
       'else': ePart
     };
   }
/  stm:SWITCH LPAR expr:expression RPAR body:statement {
     return {
       tag: 'SwitchStm',
       test: expr,
       body: body
     };
   }

// (6.8.5) 
iteration_statement =
   stm:WHILE LPAR expr:expression RPAR body:statement {
     return {
       tag: 'WhileStm',
       test: expr,
       body: body
     };
   }
/  DO body:statement WHILE LPAR expr:expression RPAR SEMI {
     return {
       tag: 'DoWhileStm',
       test: expr,
       body: body
     };
   }
/  stm:FOR LPAR dec:declaration exp1:expression? SEMI
                exp2:expression? 
           RPAR body:statement {
     return {
       tag:     'ForStm',
       'var':   dec,
       test:    exp1,
       control: exp2,
       body:    body
     };
   }
/  stm:FOR LPAR exp1:expression? SEMI 
                exp2:expression? SEMI 
                exp3:expression? 
           RPAR body:statement {
     return {
       tag:     'ForStm',
       'var':   exp1,
       test:    exp2,
       control: exp3,
       body:    body
     };
   }

// (6.8.6) 
jump_statement =
   stm:GOTO id:identifier SEMI { 
     return {
      tag: stm,
      label: id
     };
   }     
/  stm:CONTINUE SEMI { 
     return {
      tag: stm
     };
   }     
/  stm:BREAK SEMI { 
     return {
      tag: stm
     };
   }     
/  stm:RETURN expr:expression? SEMI { 
     return {
      tag: stm,
      val: expr? expr : 'none'
     };
   }     

/****************************************************************
 *                  A.2.4 External definitions                  *
 ****************************************************************/
// (6.9) 
translation_unit =
   __ ed:external_declaration+ EOT {
      return ed;
   }


// (6.9) 
external_declaration =
  include_directive
/ define_directive
/ func:function_definition { 
     return { tag: 'FunctionDec', 
              val: func }; 
   }
/  declaration

// (6.9.1) 
function_definition =
   spec:declaration_specifiers dec:declarator 
   decs:declaration*
   stm:compound_statement {
     return {
       result: spec,
       name: dec.name,
       params: dec.params.concat(decs),
       body: stm
     };
   }

// Preprocessamento de diretivas feito ad hoc, ALTERAR depois !!!!
include_directive =
   "#include" _ hn:header_name __ {
      hn.tag = 'Include';
      return hn;
   }

define_directive =
   "#define" _ id:identifier expr:expression __ {
      return { tag: 'Define',
               definiendum: id,
               definiens: expr
             };
   }



// TESTE = e:translation_unit __ { return e; }
TESTE = e:declaration __ { return e; }
//TESTE = e:direct_declarator __ { return e; }

