package com.cunoc.Simulator;

import com.cunoc.JFlex_Cup.Java.repetition.Variable;

public class SimulatorVariable {
    private Variable variable;
    private String find;
    private String who;

    public SimulatorVariable(Variable variable, String find, String who) {
        this.variable = variable;
        this.find = find;
        this.who = who;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public String getFind() {
        return find;
    }

    public void setFind(String find) {
        this.find = find;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

}
