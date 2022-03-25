package com.cunoc.JFlex_Cup.Java.repetition;

import com.cunoc.JFlex_Cup.Token;

public class Variable extends Token {

    private ListType type;

    public Variable(ListType type, int x, int y, String lexeme) {
        super(x, y, lexeme);
        this.type = type;
    }

    public ListType getType() {
        return type;
    }

    public void setType(ListType type) {
        this.type = type;
    }

}
