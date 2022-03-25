package com.cunoc.JFlex_Cup.Java.repetition;

import java.util.List;

import com.cunoc.JFlex_Cup.Token;

public class ClassSyntax {
    private String name;
    private List<Method> ListMethods;
    private List<Variable> ListVariable;
    private List<Token> ListComments;

    public ClassSyntax(String name, List<Method> listMethods, List<Variable> listVariable, List<Token> listComments) {
        this.name = name;
        ListMethods = listMethods;
        ListVariable = listVariable;
        ListComments = listComments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Method> getListMethods() {
        return ListMethods;
    }

    public void setListMethods(List<Method> listMethods) {
        ListMethods = listMethods;
    }

    public List<Variable> getListVariable() {
        return ListVariable;
    }

    public void setListVariable(List<Variable> listVariable) {
        ListVariable = listVariable;
    }

    public List<Token> getListComments() {
        return ListComments;
    }

    public void setListComments(List<Token> listComments) {
        ListComments = listComments;
    }

}
