/*primer seccion: codigo java que se copiara arriba*/
package com.cunoc.JFlex_Cup.Java;
import java_cup.runtime.*;
%%
/*segunda seccion: configuracion*/
%class Lexico
%unicode
%line
%column
%cup
%public
%{
    /*CODE*/
    private void print(String token){
        System.out.println("\n"+token);
        System.out.println("<linea:"+yyline+"><colum:"+yycolumn+"><TOKEN:"+yytext()+">");
    }
    /*CODE*/
%}
LETRAS = [á|é|í|ó|ú|ñ|â|ê|î|ô|û|Ã|±]
CARACTER = {LETRAS} | [a-zA-Z] | _  
ID = {CARACTER} ({CARACTER} | {ENTERO})*
STRING = "\"" ~"\"" 
ENTERO =  ([0]|[1-9][0-9]*)
DECIMAL = {ENTERO}[.]{ENTERO}
espacio =[\r|\t|\f|\n|\s| ]+
%%
/*tercer seccion: reglase lexicas*/
/*INGNORAR*/
"/*" ~"*/"          {/*COMENTARIO MULTILINEA*/}
"//".*"\n"          {/*COMENTARIO DE UNA LINEA*/}
{espacio}           {/*ESPACIOS*/}
/*FINAL INGNORAR*/
/*RECORDAR  {return new Symbol(sym.BYTE(INT),yyline(INT),yycolumn, (yytext()))(OBJET); }*/
/*VARIALBES PRIMITIVAS*/
"byte"              {print("byte");return new Symbol(sym.BYTE,yyline,yycolumn, (yytext())); }
"short"             {print("short");return new Symbol(sym.SHORT,yyline,yycolumn, (yytext())); }
"int"               {print("int");return new Symbol(sym.INT,yyline,yycolumn, (yytext())); }
"long"              {print("long");return new Symbol(sym.LONG,yyline,yycolumn, (yytext())); }
"float"             {print("float");return new Symbol(sym.FLOAT,yyline,yycolumn, (yytext())); }
"double"            {print("double");return new Symbol(sym.DOUBLE,yyline,yycolumn, (yytext())); }
"char"              {print("char");return new Symbol(sym.CHAR,yyline,yycolumn, (yytext())); }
"boolean"           {print("boolean");return new Symbol(sym.BOOLEAN,yyline,yycolumn, (yytext())); }
"String"            {print("String");return new Symbol(sym.STRING,yyline,yycolumn, (yytext())); }
/*FINAL VARIALBES PRIMITIVAS*/
"true"              {print("true");return new Symbol(sym.TRUE,yyline,yycolumn, (yytext())); }
"false"             {print("false");return new Symbol(sym.FALSE,yyline,yycolumn, (yytext())); }
{DECIMAL}"f"        {print("F");return new Symbol(sym.F,yyline,yycolumn, (yytext())); }
"/u"{ENTERO}[a-z]?  {print("CHARTN");return new Symbol(sym.CHARTN,yyline,yycolumn, (yytext())); }
/*PALABRAS RESERVADAS*/
"package"           {return new Symbol(sym.PACKAGE,yyline,yycolumn, (yytext())); }
"import"            {return new Symbol(sym.IMPORT,yyline,yycolumn, (yytext())); }
"class"             {print("class");return new Symbol(sym.CLASS,yyline,yycolumn, (yytext())); }
"this"              {print("this");return new Symbol(sym.THIS,yyline,yycolumn, (yytext())); }

"extends"           {print("extends");return new Symbol(sym.EXNTENDS,yyline,yycolumn, (yytext())); }
"implements"        {print("implements");return new Symbol(sym.IMPLEMENTS,yyline,yycolumn, (yytext())); }
"super"             {print("super");return new Symbol(sym.SUPER,yyline,yycolumn, (yytext())); }

"new"               {print("new");return new Symbol(sym.NEW,yyline,yycolumn, (yytext())); }
"void"              {return new Symbol(sym.VOID,yyline,yycolumn, (yytext())); }

"try"               {print("try");return new Symbol(sym.TRY,yyline,yycolumn, (yytext())); }
"catch"             {print("catch");return new Symbol(sym.CATCH,yyline,yycolumn, (yytext())); }

/*SENTENCIAS DE CONTORL*/
"for"               {print("for");return new Symbol(sym.FOR,yyline,yycolumn, (yytext())); }
"while"             {print("while");return new Symbol(sym.WHILE,yyline,yycolumn, (yytext())); }
"do"                {print("do");return new Symbol(sym.DO,yyline,yycolumn, (yytext())); }
"if"                {print("if");return new Symbol(sym.IF,yyline,yycolumn, (yytext())); }
"else"              {print("else");return new Symbol(sym.ELSE,yyline,yycolumn, (yytext())); }
"switch"            {print("switch");return new Symbol(sym.SWITCH,yyline,yycolumn, (yytext())); }

"case"              {print("CASE");return new Symbol(sym.CASE,yyline,yycolumn, (yytext())); }
/*FIN SENTENCIAS DE CONTORL*/
/*FINAL SENTENCIAS DE CONTORL*/
"break"             {print("break");return new Symbol(sym.BREAK,yyline,yycolumn, (yytext())); }
"return"            {print("return");return new Symbol(sym.RETURN,yyline,yycolumn, (yytext())); }
/*FIN FINAL SENTENCIAS DE CONTORL*/
/*FINAL PALABRAS RESERVADAS*/
/*VISIBILIDA*/
"private"           {return new Symbol(sym.PRIVATE,yyline,yycolumn, (yytext())); }
"public"            {return new Symbol(sym.PUBLIC,yyline,yycolumn, (yytext())); }
"protected"         {return new Symbol(sym.PROTECTED,yyline,yycolumn, (yytext())); }
"final"             {print("final");return new Symbol(sym.FINAL,yyline,yycolumn, (yytext())); }
"static"            {return new Symbol(sym.STATIC,yyline,yycolumn, (yytext())); }
/*FIN VISIBILIDA*/
/*SIMBOLOS DE PUNTUACION*/
"'"                 {print("'");return new Symbol(sym.SIMPLE_COMILLA,yyline,yycolumn, (yytext())); }
";"                 {print(";");return new Symbol(sym.PUNTO_COMA,yyline,yycolumn, (yytext())); }
":"                 {print(":");return new Symbol(sym.DOBLE_PUNTO,yyline,yycolumn, (yytext())); }
"."                 {print(".");return new Symbol(sym.PUNTO,yyline,yycolumn, (yytext())); }
","                 {print(",");return new Symbol(sym.COMA,yyline,yycolumn, (yytext())); }
/*FINAL SIMBOLOS DE PUNTUACION*/
/*SIMBOLOS ARITMETRICOS*/
"+"                 {print("+");return new Symbol(sym.SUMA,yyline,yycolumn, (yytext())); }
"-"                 {print("-");return new Symbol(sym.RESTA,yyline,yycolumn, (yytext())); }
"*"                 {print("*");return new Symbol(sym.MULTIPLICACION,yyline,yycolumn, (yytext())); }
"/"                 {print("/");return new Symbol(sym.DIVISION,yyline,yycolumn, (yytext())); }
"%"                 {print("%");return new Symbol(sym.MODULO,yyline,yycolumn, (yytext())); }
//"++"                {return new Symbol(sym.INCREMENTO,yyline,yycolumn, (yytext())); }
//"--"                {return new Symbol(sym.DECREMENTO,yyline,yycolumn, (yytext())); }
/*FINAL SIMBOLOS ARITMETRICOS*/
/*SIMBOLOS OPERADOR*/
"="                 {print("IGUAL");return new Symbol(sym.IGUAL,yyline,yycolumn, (yytext())); }
//+= , -= , *= , /= , %=
/*FINAL SIMBOLOS OPERADOR*/
/*SIMBOLOS OPERADOR RELACIONALES*/
"<"                 {print("<");return new Symbol(sym.MENOR_Q,yyline,yycolumn, (yytext())); }
">"                 {print(">");return new Symbol(sym.MAYOR_Q,yyline,yycolumn, (yytext())); }
"&"                 {print("&");return new Symbol(sym.Y,yyline,yycolumn, (yytext())); }
"|"                 {print("|");return new Symbol(sym.O,yyline,yycolumn, (yytext())); }
//== , >= , <=
/*FINAL SIMBOLOS OPERADOR RELACIONALES*/
/*SIMBOLO DE AGRUPACION*/
"("                 {print("(");return new Symbol(sym.P_APERTURA,yyline,yycolumn, (yytext())); }
")"                 {print(")");return new Symbol(sym.P_CIERRE,yyline,yycolumn, (yytext())); }
"{"                 {print("{");return new Symbol(sym.L_APERTURA,yyline,yycolumn, (yytext())); }
"}"                 {print("}");return new Symbol(sym.L_CIERRE,yyline,yycolumn, (yytext())); }
"["                 {print("[");return new Symbol(sym.C_APERTURA,yyline,yycolumn, (yytext())); }
"]"                 {print("]");return new Symbol(sym.C_CIERRE,yyline,yycolumn, (yytext())); }
/*FINAL SIMBOLO DE AGRUPACION*/
/*Token*/
{STRING}            {print("{STRING}");return new Symbol(sym.TEXT,yyline,yycolumn, (yytext())); }
{ENTERO}            {print("{ENTERO}");return new Symbol(sym.ENTERO,yyline,yycolumn, (yytext())); }
{DECIMAL}           {print("{DECIMAL}");return new Symbol(sym.DECIMAL,yyline,yycolumn, (yytext())); }
{ID}                {print("{ID}");return new Symbol(sym.ID,yyline,yycolumn, (yytext())); }
/*ERROR LEXICO*/
"'"."'"             {print("CUALQUIER CARACTER");return new Symbol(sym.CARACTER,yyline,yycolumn, (yytext())); }
[^]                 { System.out.println("error");throw new Error("Illegal character <"+yytext()+">"); }