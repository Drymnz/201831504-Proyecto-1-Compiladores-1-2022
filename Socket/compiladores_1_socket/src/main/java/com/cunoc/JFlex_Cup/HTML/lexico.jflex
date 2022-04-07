/*primer seccion: codigo java que se copiara arriba*/
package com.cunoc.JFlex_Cup.HTML;
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
    private  List<Token> listComments =  new ArrayList<>();
    private String report = "";
    private void addComments(){
        listComments.add(new Token((yyline+1),(yycolumn+1),yytext()));
    }
    private void print(String token){
        //Console.ConsoleText.append("\n<linea:"+(yyline+1)+"><colum:"+(yycolumn+1)+"><TOKEN:"+yytext()+">");
        report+="\n<linea:"+(yyline+1)+"><colum:"+(yycolumn+1)+"><TOKEN:"+yytext()+">";
    }
    public String getReport(){
        return this.report;
    }
    public void setReport(String repor){
        this.report = repor;
    }
    
    public List<Token>  getlistComments(){
        return this.listComments;
    };
%}
LETRAS = [á|é|í|ó|ú|ñ|â|ê|î|ô|û|Ã|±]
CARACTER = {LETRAS} | [a-zA-Z0-9] | _  
ID = {CARACTER} ({CARACTER} | {ENTERO})*
STRING = "\"" ~"\""
ENTERO = ([0]|[1-9][0-9]*)
DECIMAL = {ENTERO}[.]{ENTERO}
espacio =[\n | \r | \t | \f | \b]+
%%
/*tercer seccion: reglase lexicas*/
/*INGNORAR*/
"</" ~"/>"          {addComments();/*COMENTARIO*/}
{espacio}           {/*ESPACIOS*/}
/*FINAL INGNORAR*/
"<html>"			{print("INICIO_HTML"    );return new Symbol(sym.INICIO_HTML ,yyline,yycolumn, (yytext())); }
"</html>"			{print("FINAL_HTML"     );return new Symbol(sym.FINAL_HTML  ,yyline,yycolumn, (yytext())); }
"<h"{ENTERO}">"		{print("INICIO_H"       );return new Symbol(sym.INICIO_H    ,yyline,yycolumn, (yytext())); }
"</h"{ENTERO}">"	{print("FINAL_H"        );return new Symbol(sym.FINAL_H     ,yyline,yycolumn, (yytext())); }
"<table>"		 	{print("INICIO_TAB"     );return new Symbol(sym.INICIO_TAB  ,yyline,yycolumn, (yytext())); }
"</table>"			{print("FINAL_TAB"      );return new Symbol(sym.FINAL_TAB   ,yyline,yycolumn, (yytext())); }
"<tr>"		 		{print("INICIO_TR"      );return new Symbol(sym.INICIO_TR   ,yyline,yycolumn, (yytext())); }
"</tr>"				{print("FINAL_TR"       );return new Symbol(sym.FINAL_TR    ,yyline,yycolumn, (yytext())); }
"<th>"		 		{print("INICIO_TH"      );return new Symbol(sym.INICIO_TH   ,yyline,yycolumn, (yytext())); }
"</th>"				{print("FINAL_TH"       );return new Symbol(sym.FINAL_TH    ,yyline,yycolumn, (yytext())); }
"<td>"		 		{print("INICIO_TD"      );return new Symbol(sym.INICIO_TD   ,yyline,yycolumn, (yytext())); }
"</td>"				{print("FINAL_TD"       );return new Symbol(sym.FINAL_TD    ,yyline,yycolumn, (yytext())); }
"<br>"		 		{print("INICIO_BR"      );return new Symbol(sym.INICIO_BR   ,yyline,yycolumn, (yytext())); }
"</br>"				{print("FINAL_BR"       );return new Symbol(sym.FINAL_BR    ,yyline,yycolumn, (yytext())); }
/*PALABRAS CLAVES*/
"$$"			    {print("$$"         );return new Symbol(sym.USER,yyline,yycolumn, (yytext())); }
"integer"			{print("Integer"    );return new Symbol(sym.INTEGER,yyline,yycolumn, (yytext())); }
"String"			{print("String"     );return new Symbol(sym.STRING,yyline,yycolumn, (yytext())); }
"RESULT"			{print("RESULT"     );return new Symbol(sym.RESULT,yyline,yycolumn, (yytext())); }
"Comentarios"		{print("Comentarios");return new Symbol(sym.COMMENT,yyline,yycolumn, (yytext())); }
"Metodos"		    {print("Metodos"    );return new Symbol(sym.METHODS,yyline,yycolumn, (yytext())); }
"Variables"		    {print("Variables"  );return new Symbol(sym.VARIABLE,yyline,yycolumn, (yytext())); }
"Score"		    {}
/*FINAL PALABRAS CLAVES*/
/*SIMBOLOS DE PUNTUACION*/
"'"                 {print("'");return new Symbol(sym.SIMPLE_COMILLA,yyline,yycolumn, (yytext())); }
";"                 {print(";");return new Symbol(sym.PUNTO_COMA,yyline,yycolumn, (yytext())); }
","                 {print(":");return new Symbol(sym.COMA,yyline,yycolumn, (yytext())); }
"."                 {print(".");return new Symbol(sym.PUNTO,yyline,yycolumn, (yytext())); }
/*FINAL SIMBOLOS DE PUNTUACION*/
/*SIMBOLOS ARITMETRICOS*/
"+"                 {print("+");return new Symbol(sym.SUMA,yyline,yycolumn, (yytext())); }
"-"                 {print("-");return new Symbol(sym.RESTA,yyline,yycolumn, (yytext())); }
"*"                 {print("*");return new Symbol(sym.MULTIPLICACION,yyline,yycolumn, (yytext())); }
"/"                 {print("/");return new Symbol(sym.DIVISION,yyline,yycolumn, (yytext())); }
/*FINAL SIMBOLOS ARITMETRICOS*/
/*SIMBOLO DE AGRUPACION*/
"("                 {print("(");return new Symbol(sym.P_APERTURA,yyline,yycolumn, (yytext())); }
")"                 {print(")");return new Symbol(sym.P_CIERRE,yyline,yycolumn, (yytext())); }
"{"                 {print("{");return new Symbol(sym.L_APERTURA,yyline,yycolumn, (yytext())); }
"}"                 {print("}");return new Symbol(sym.L_CIERRE,yyline,yycolumn, (yytext())); }
"["                 {print("[");return new Symbol(sym.C_APERTURA,yyline,yycolumn, (yytext())); }
"]"                 {print("]");return new Symbol(sym.C_CIERRE,yyline,yycolumn, (yytext())); }
/*FINAL SIMBOLO DE AGRUPACION*/
/*Token*/
{STRING}            {print("{STRING}" );return new Symbol(sym.TEXT,yyline,yycolumn, (yytext())); }
{ID}            	{print("{ID}" );return new Symbol(sym.ID,yyline,yycolumn, (yytext())); }
{ENTERO}|{DECIMAL}  {print("{ID}" );return new Symbol(sym.NUM,yyline,yycolumn, (yytext())); }
/*ERROR LEXICO*/
[^]                 { print("ERROR"); }