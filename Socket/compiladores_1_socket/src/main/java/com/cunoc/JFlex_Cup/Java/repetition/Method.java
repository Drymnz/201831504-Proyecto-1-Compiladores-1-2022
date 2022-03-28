package com.cunoc.JFlex_Cup.Java.repetition;

import java.util.List;

import com.cunoc.JFlex_Cup.Token;

public class Method extends Token {
    private ListType type;
    private List<Variable> listParameters;
    private boolean flag = false;

    public Method( ListType type, List<Variable> listParameters, int x, int y, String lexeme) {
        super(x, y, lexeme);
        this.type = type;
        this.listParameters = listParameters;
    }

    public ListType getType() {
        return type;
    }

    public void setType(ListType type) {
        this.type = type;
    }

    public List<Variable> getListParameters() {
        return listParameters;
    }

    public void selListParameters(List<Variable> listParameters) {
        this.listParameters = listParameters;
    }

    public void setListParameters(List<Variable> listParameters) {
        this.listParameters = listParameters;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    

}
