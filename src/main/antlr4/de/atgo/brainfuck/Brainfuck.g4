grammar Brainfuck;

prog: (stat)+;

stat:       '>'                 #movr
        |   '<'                 #movl
        |   '+'                 #inc
        |   '-'                 #dec
        |   '.'                 #out
        |   ','                 #in
        |   '[' (stat)* ']'     #loop
        ;

WS: . -> skip;
