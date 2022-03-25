package com.cunoc.Analyzer;

import java.util.ArrayList;
import java.util.List;

import com.cunoc.JFlex_Cup.Token;
import com.cunoc.JFlex_Cup.Java.repetition.Method;
import com.cunoc.Simulator.SimulatorVariable;

public class JSon {
    private double score = 0;
    private List<String> ListNameClass = new ArrayList<>();
    private List<Method> ListMethods = new ArrayList<>();
    private List<SimulatorVariable> ListVariable = new ArrayList<>();
    private List<Token> ListComments = new ArrayList<>();

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public List<String> getListNameClass() {
        return ListNameClass;
    }

    public void setListNameClass(List<String> listNameClass) {
        ListNameClass = listNameClass;
    }

    public List<Method> getListMethods() {
        return ListMethods;
    }

    public void setListMethods(List<Method> listMethods) {
        ListMethods = listMethods;
    }

    public List<Token> getListComments() {
        return ListComments;
    }

    public void setListComments(List<Token> listComments) {
        ListComments = listComments;
    }

    public List<SimulatorVariable> getListVariable() {
        return ListVariable;
    }

    public void setListVariable(List<SimulatorVariable> listVariable) {
        ListVariable = listVariable;
    }

}
