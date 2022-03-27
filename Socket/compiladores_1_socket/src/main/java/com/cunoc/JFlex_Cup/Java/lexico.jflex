/*primer seccion: codigo java que se copiara arriba*/
package com.cunoc.JFlex_Cup.Java;
import java_cup.runtime.*;
import java.util.List;
import java.util.ArrayList;
import com.cunoc.JFlex_Cup.Token;
import com.cunoc.Server.Console;
%%
/*segunda seccion: configuracion*/
%class Lexico
%unicode
%line
%column
%cup
%public
%{
    List<Token> listComments =  new ArrayList<>();
    private void addComments(){
        listComments.add(new Token((yyline+1),(yycolumn+1),yytext()));
    }
    private void print(String token){
         Console.ConsoleText.append("\n<linea:"+(yyline+1)+"><colum:"+(yycolumn+1)+"><TOKEN:"+yytext()+">");
        System.out.println("\n<linea:"+(yyline+1)+"><colum:"+(yycolumn+1)+"><TOKEN:"+yytext()+">");
    }
    
    public List<Token>  getlistComments(){
        return this.listComments;
    };
%}
LETRAS = [á|é|í|ó|ú|ñ|â|ê|î|ô|û|Ã|±]
CARACTER = {LETRAS} | [a-zA-Z] | _  
ID = {CARACTER} ({CARACTER} | {ENTERO})*
STRING = "\"" ~"\""
OR = ('\u007c')|('|')|("|")|('\u007c')
ENTERO = [+|-]? ([0]|[1-9][0-9]*)
DECIMAL = {ENTERO}[.]{ENTERO}
espacio =[\n | \r | \t | \f | \b]+
%%
/*tercer seccion: reglase lexicas*/
/*INGNORAR*/
"/*" ~"*/"          {addComments();/*COMENTARIO MULTILINEA*/}
"//" ~"\n"          {addComments();/*COMENTARIO DE UNA LINEA*/}
{espacio}           {/*ESPACIOS*/}
/*FINAL INGNORAR*/
/*VARIALBES PRIMITIVAS*/
"byte"              {print("byte" );return new Symbol(sym.BYTE,yyline,yycolumn, (yytext())); }
"short"             {print("short" );return new Symbol(sym.SHORT,yyline,yycolumn, (yytext())); }
"int"               {print("int" );return new Symbol(sym.INT,yyline,yycolumn, (yytext())); }
"long"              {print("long" );return new Symbol(sym.LONG,yyline,yycolumn, (yytext())); }
"float"             {print("float" );return new Symbol(sym.FLOAT,yyline,yycolumn, (yytext())); }
"double"            {print("double" );return new Symbol(sym.DOUBLE,yyline,yycolumn, (yytext())); }
"char"              {print("char" );return new Symbol(sym.CHAR,yyline,yycolumn, (yytext())); }
"boolean"           {print("boolean" );return new Symbol(sym.BOOLEAN,yyline,yycolumn, (yytext())); }
"String"            {print("String" );return new Symbol(sym.STRING,yyline,yycolumn, (yytext())); }
/*FINAL VARIALBES PRIMITIVAS*/
"true"              {print("true" );return new Symbol(sym.TRUE,yyline,yycolumn, (yytext())); }
"false"             {print("false" );return new Symbol(sym.FALSE,yyline,yycolumn, (yytext())); }
{DECIMAL}"f"        {print("f");return new Symbol(sym.F,yyline,yycolumn, (yytext())); }
"/u"{ENTERO}[a-z]?  {print("/u");return new Symbol(sym.CHARTN,yyline,yycolumn, (yytext())); }
/*PALABRAS RESERVADAS*/
"package"           {print("package" );return new Symbol(sym.PACKAGE,yyline,yycolumn, (yytext())); }
"import"            {print("import" );return new Symbol(sym.IMPORT,yyline,yycolumn, (yytext())); }
"class"             {print("class" );return new Symbol(sym.CLASS,yyline,yycolumn, (yytext())); }
"this"              {print("this" );return new Symbol(sym.THIS,yyline,yycolumn, (yytext())); }
"extends"           {print("extends" );return new Symbol(sym.EXNTENDS,yyline,yycolumn, (yytext())); }
"implements"        {print("implements" );return new Symbol(sym.IMPLEMENTS,yyline,yycolumn, (yytext())); }
"super"             {print("super" );return new Symbol(sym.SUPER,yyline,yycolumn, (yytext())); }
"new"               {print("new" );return new Symbol(sym.NEW,yyline,yycolumn, (yytext())); }
"void"              {print("void" );return new Symbol(sym.VOID,yyline,yycolumn, (yytext())); }
"try"               {print("try" );return new Symbol(sym.TRY,yyline,yycolumn, (yytext())); }
"catch"             {print("catch" );return new Symbol(sym.CATCH,yyline,yycolumn, (yytext())); }
/*SENTENCIAS DE CONTORL*/
"for"               {print("for" );return new Symbol(sym.FOR,yyline,yycolumn, (yytext())); }
"while"             {print("while" );return new Symbol(sym.WHILE,yyline,yycolumn, (yytext())); }
"do"                {print("do" );return new Symbol(sym.DO,yyline,yycolumn, (yytext())); }
"if"                {print("if" );return new Symbol(sym.IF,yyline,yycolumn, (yytext())); }
"else"              {print("else" );return new Symbol(sym.ELSE,yyline,yycolumn, (yytext())); }
"switch"            {print("switch" );return new Symbol(sym.SWITCH,yyline,yycolumn, (yytext())); }
"case"              {print("case" );return new Symbol(sym.CASE,yyline,yycolumn, (yytext())); }
/*FIN SENTENCIAS DE CONTORL*/
/*FINAL SENTENCIAS DE CONTORL*/
"break"             {print("break" );return new Symbol(sym.BREAK,yyline,yycolumn, (yytext())); }
"default"           {print("default" );return new Symbol(sym.DEFAULT,yyline,yycolumn, (yytext())); }
"return"            {print("return" );return new Symbol(sym.RETURN,yyline,yycolumn, (yytext())); }
/*FIN FINAL SENTENCIAS DE CONTORL*/
/*FINAL PALABRAS RESERVADAS*/
/*VISIBILIDA*/
"private"           {print("private" );return new Symbol(sym.PRIVATE,yyline,yycolumn, (yytext())); }
"public"            {print("public" );return new Symbol(sym.PUBLIC,yyline,yycolumn, (yytext())); }
"protected"         {print("protected" );return new Symbol(sym.PROTECTED,yyline,yycolumn, (yytext())); }
"final"             {print("final" );return new Symbol(sym.FINAL,yyline,yycolumn, (yytext())); }
"static"            {print("static" );return new Symbol(sym.STATIC,yyline,yycolumn, (yytext())); }
/*FIN VISIBILIDA*/
/*SIMBOLOS DE PUNTUACION*/
"'"                 {print("'"                 );return new Symbol(sym.SIMPLE_COMILLA,yyline,yycolumn, (yytext())); }
";"                 {print(";"                 );return new Symbol(sym.PUNTO_COMA,yyline,yycolumn, (yytext())); }
":"                 {print(":"                 );return new Symbol(sym.DOBLE_PUNTO,yyline,yycolumn, (yytext())); }
"."                 {print("."                 );return new Symbol(sym.PUNTO,yyline,yycolumn, (yytext())); }
","                 {print(","                 );return new Symbol(sym.COMA,yyline,yycolumn, (yytext())); }
/*FINAL SIMBOLOS DE PUNTUACION*/
/*SIMBOLOS ARITMETRICOS*/
"+="                {print("+="                );return new Symbol(sym.SUMA_IGUAL,yyline,yycolumn, (yytext())); }
"++"                {print("++"                );return new Symbol(sym.CREMENTO,yyline,yycolumn, (yytext())); }
"+"                 {print("+"                 );return new Symbol(sym.SUMA,yyline,yycolumn, (yytext())); }
"--"                {print("--"                );return new Symbol(sym.INCREMENTO,yyline,yycolumn, (yytext())); }
"-="                {print("-="                );return new Symbol(sym.RESTA_IGUAL,yyline,yycolumn, (yytext())); }
"-"                 {print("-"                 );return new Symbol(sym.RESTA,yyline,yycolumn, (yytext())); }
"*="                {print("*="                );return new Symbol(sym.MULTIPLICACION_IGUAL,yyline,yycolumn, (yytext())); }
"*"                 {print("*"                 );return new Symbol(sym.MULTIPLICACION,yyline,yycolumn, (yytext())); }
"/="                {print("/="                );return new Symbol(sym.DIVISION_IGUAL,yyline,yycolumn, (yytext())); }
"/"                 {print("/"                 );return new Symbol(sym.DIVISION,yyline,yycolumn, (yytext())); }
"%="                {print("%="                );return new Symbol(sym.MODULO_IGUAL,yyline,yycolumn, (yytext())); }
"%"                 {print("%"                 );return new Symbol(sym.MODULO,yyline,yycolumn, (yytext())); }
/*FINAL SIMBOLOS ARITMETRICOS*/
/*SIMBOLOS OPERADOR RELACIONALES*/
{OR}{OR}            {print("OROR"                );return new Symbol(sym.TWOO,yyline,yycolumn, (yytext())); }
"&&"                {print("&&"                );return new Symbol(sym.TWOY,yyline,yycolumn, (yytext())); }
"=="                {print("=="                );return new Symbol(sym.DOUBLE_IGUAL,yyline,yycolumn, (yytext())); }
"<="                {print("<="                );return new Symbol(sym.MENOR_Q_IGUAL,yyline,yycolumn, (yytext())); }
">="                {print(">="                );return new Symbol(sym.MAYOR_Q_IGUAL,yyline,yycolumn, (yytext())); }
"<"                 {print("<"                 );return new Symbol(sym.MENOR_Q,yyline,yycolumn, (yytext())); }
">"                 {print(">"                 );return new Symbol(sym.MAYOR_Q,yyline,yycolumn, (yytext())); }
"&"                 {print("&"                 );return new Symbol(sym.ONEY,yyline,yycolumn, (yytext())); }
{OR}                {print("OR"                 );return new Symbol(sym.ONEO,yyline,yycolumn, (yytext())); }
/*SIMBOLOS OPERADOR*/
"="                 {print("="                 );return new Symbol(sym.IGUAL,yyline,yycolumn, (yytext())); }
"!="                {print("!="                );return new Symbol(sym.ADMIRACION_IGUAL,yyline,yycolumn, (yytext())); }
"!"                 {print("!"                 );return new Symbol(sym.ADMIRACION,yyline,yycolumn, (yytext())); }
"?"                 {print("?"                 );return new Symbol(sym.INTERO,yyline,yycolumn, (yytext())); }
//+= , -= , *= , /= , %=
/*FINAL SIMBOLOS OPERADOR*/
//== , >= , <=
/*FINAL SIMBOLOS OPERADOR RELACIONALES*/
/*SIMBOLO DE AGRUPACION*/
"("                 {print("("                 );return new Symbol(sym.P_APERTURA,yyline,yycolumn, (yytext())); }
")"                 {print(")"                 );return new Symbol(sym.P_CIERRE,yyline,yycolumn, (yytext())); }
"{"                 {print("{"                 );return new Symbol(sym.L_APERTURA,yyline,yycolumn, (yytext())); }
"}"                 {print("}"                 );return new Symbol(sym.L_CIERRE,yyline,yycolumn, (yytext())); }
"["                 {print("["                 );return new Symbol(sym.C_APERTURA,yyline,yycolumn, (yytext())); }
"]"                 {print("]"                 );return new Symbol(sym.C_CIERRE,yyline,yycolumn, (yytext())); }
/*FINAL SIMBOLO DE AGRUPACION*/
/*Token*/
{STRING}            {print("{STRING}" );return new Symbol(sym.TEXT,yyline,yycolumn, (yytext())); }
{ENTERO}            {print("{ENTERO}" );return new Symbol(sym.ENTERO,yyline,yycolumn, (yytext())); }
{DECIMAL}           {print("{DECIMAL}" );return new Symbol(sym.DECIMAL,yyline,yycolumn, (yytext())); }
{ID}                {print("{ID}" );return new Symbol(sym.ID,yyline,yycolumn, (yytext())); }
/*ERROR LEXICO*/
"'"."'"             {print("'"+"'"             );return new Symbol(sym.CARACTER,yyline,yycolumn, (yytext())); }
    [^]                              { throw new Error("Illegal character <"+yytext()+">"); }