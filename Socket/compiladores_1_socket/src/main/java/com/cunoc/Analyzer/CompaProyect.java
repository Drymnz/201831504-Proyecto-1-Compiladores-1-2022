package com.cunoc.Analyzer;

import java.util.ArrayList;
import java.util.List;

import com.cunoc.JFlex_Cup.Token;
import com.cunoc.JFlex_Cup.Java.repetition.ClassSyntax;
import com.cunoc.JFlex_Cup.Java.repetition.Method;
import com.cunoc.JFlex_Cup.Java.repetition.Variable;
import com.cunoc.Server.Console;
import com.cunoc.Simulator.SimulatorVariable;

public class CompaProyect extends Thread {
    private final double MULTIPLIER = 0.25;
    private double score = 0;
    private int numVariable = 0;
    private int numComments = 0;
    private int numMethods = 0;
    private int numClass = 0;
    private ArrayList<ClassSyntax> poryectTwo;
    private ArrayList<ClassSyntax> poryectOne;
    private JSon exportar = new JSon();

    public CompaProyect(ArrayList<ClassSyntax> poryectTwo, ArrayList<ClassSyntax> poryectOne) {
        this.poryectTwo = poryectTwo;
        this.poryectOne = poryectOne;
    }

    // json
    public JSon compaAnalyzer() {
        this.start();
        analyzerMethod();// n4
        analyzerVariable();// n4
        try {
            do {
                Thread.sleep(500);
            } while (this.isAlive());
        } catch (Exception e) {
            String mensaje = "Error en CompaProyect " + e.getMessage();
            System.out.println(mensaje);
            Console.ConsoleText.append(mensaje);
        }
        score = score(exportar.getListComments().size(), this.numComments)
                + score(exportar.getListMethods().size(), this.numMethods)
                + score(exportar.getListNameClass().size(), this.numClass)
                + score(exportar.getListVariable().size(), this.numVariable);
        exportar.setScore(score);
        return exportar;
    }

    // analisar metodos //n4
    private void analyzerMethod() {
        for (ClassSyntax classSyntax : poryectOne) {// n
            for (ClassSyntax classSyntaxComparar : poryectTwo) {// n2
                // analyzer class
                for (Method methodOne : classSyntax.getListMethods()) {// n3
                    for (Method methodTWO : classSyntaxComparar.getListMethods()) {
                        if (equivalentMethod(methodOne, methodTWO)) {// n4
                            exportar.getListMethods().add(methodOne);
                            methodTWO.setFlag(true);
                        }
                    }
                }
            }
        }
    }

    // n
    private boolean equivalentMethod(Method methodOne, Method methodTWO) {
        if (!methodTWO.isFlag()) {
            if (analyzerNameClass(methodOne.getLexeme(), methodTWO.getLexeme())
                    && equivalentParamet(methodOne.getListParameters(), methodTWO.getListParameters())) {
                return true;
            }
        }
        return false;
    }

    // n
    private boolean equivalentParamet(List<Variable> listParametersOne, List<Variable> listParametersTwo) {
        int i = (listParametersOne.size() > listParametersTwo.size()) ? listParametersTwo.size()
                : listParametersOne.size();
        int conter = 0;
        if (i == 0) {
            return listParametersOne.size() == listParametersTwo.size();
        }
        for (int j = 0; j < i; j++) {
            if (equivalentVariable(listParametersOne.get(j), listParametersTwo.get(j))) {
                conter++;
            }
        }
        return conter == i;
    }

    // ANALYZE VARIABLE //n4
    private void analyzerVariable() {
        for (ClassSyntax classSyntax : poryectOne) {// n
            for (ClassSyntax classSyntaxComparar : poryectTwo) {// n2
                for (Variable variable : classSyntax.getListVariable()) {// n3
                    // con los atributos clase uno y clase dos
                    for (Variable variableTWO : classSyntaxComparar.getListVariable()) {// n4
                        if (equivalentVariable(variable, variableTWO)) {
                            exportar.getListVariable().add(new SimulatorVariable(variable, classSyntax.getName(),
                                    classSyntaxComparar.getName()));
                            variableTWO.setBandera(true);
                        }
                    }
                    // parametros de clase dos
                    for (Method method : classSyntaxComparar.getListMethods()) {// n4
                        for (Variable variableTWO : method.getListParameters()) {
                            if (equivalentVariable(variable, variableTWO)) {
                                exportar.getListVariable().add(
                                        new SimulatorVariable(variable, classSyntax.getName(), method.getLexeme()));
                                variableTWO.setBandera(true);
                            }
                        }
                    }
                }
                for (Method methodClassOne : classSyntax.getListMethods()) {
                    //parametros de metos primera clase, con las variables de la segunda
                    for (Variable variable : methodClassOne.getListParameters()) {
                        for (Variable variableTWO : classSyntaxComparar.getListVariable()) {// n4
                            if (equivalentVariable(variable, variableTWO)) {
                                exportar.getListVariable()
                                        .add(new SimulatorVariable(variable, methodClassOne.getLexeme(),
                                                classSyntaxComparar.getName()));
                                variableTWO.setBandera(true);
                            }
                        }
                        //con sus parametros con 
                        for (Method method : classSyntaxComparar.getListMethods()) {// n4
                            for (Variable variableTWO : method.getListParameters()) {
                                if (equivalentVariable(variable, variableTWO)) {
                                    exportar.getListVariable().add(
                                            new SimulatorVariable(variable, method.getLexeme(),
                                                    classSyntaxComparar.getName()));
                                    variableTWO.setBandera(true);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // n1
    private void analyzerClass(ClassSyntax classSyntax, ClassSyntax classSyntaxComparar) {
        // if name class ==
        if (analyzerNameClass(classSyntax.getName(), classSyntaxComparar.getName())
                & analyzerMethodClass(classSyntax.getListMethods(), classSyntaxComparar.getListMethods())) {
            exportar.getListNameClass().add(classSyntaxComparar.getName());
        }
    }

    // n1
    private boolean analyzerMethodClass(List<Method> classOne, List<Method> classTwo) {
        int i = (classOne.size() > classTwo.size()) ? classTwo.size() : classOne.size();
        int conter = 0;
        if (i == 0) {
            return classOne.size() == classTwo.size();
        }
        for (int j = 0; j < i; j++) {
            // solo si el metodo tiene el mismo nombre de funcion
            if (analyzerNameClass(classOne.get(j).getLexeme(), classTwo.get(j).getLexeme())) {
                conter++;
            }
        }
        return conter == i;
    }

    private boolean analyzerNameClass(String classSyntax, String classSyntaxComparar) {
        return classSyntax.equals(classSyntaxComparar);
    }

    // ANALYZE COMMENTS AND NAME CLASS//n3
    private void analyzerCommentsClass() {
        for (ClassSyntax classSyntax : poryectOne) {// n
            for (ClassSyntax classSyntaxComparar : poryectTwo) {// n2
                // analyzer class
                analyzerClass(classSyntax, classSyntaxComparar);// n3
                for (Token tokenONE : classSyntax.getListComments()) {// n3
                    for (Token tokenTWO : classSyntaxComparar.getListComments()) {
                        if (equivalentComments(tokenONE, tokenTWO)) {
                            exportar.getListComments().add(tokenTWO);
                        }
                    }
                }
            }
        }
    }

    // Repeated variable if identifier and type are the same
    // Variable repetida si el identificador y tipo son lo mismo
    private boolean equivalentVariable(Variable variable, Variable variableTWO) {
        if (!variableTWO.isBandera()) {
            return (variable.getLexeme().equals(variableTWO.getLexeme()))
                    && (variable.getType() == variableTWO.getType());
        } else {
            return false;
        }
    }

    // same text
    // mismo texto
    private boolean equivalentComments(Token tokenONE, Token tokenTWO) {
        return tokenONE.getLexeme().equals(tokenTWO.getLexeme());
    }

    // calcular score
    // calculate score
    private double score(double repetido, double suma) {
        if (suma > 0) {
            return (repetido / suma) * MULTIPLIER;
        }
        return 0;
    }

    @Override
    public void run() {
        try {
            sumar();// n2
            analyzerCommentsClass();// n3
        } catch (Exception e) {
            System.out.println("Fallo en la analizacionde variable");
        }
    }

    private void sumar() {
        this.numClass = poryectTwo.size() + poryectOne.size();
        conterner(this.poryectTwo);
        conterner(this.poryectOne);
    }
    //total variable counter / contador de total de variables
    private void conterner(ArrayList<ClassSyntax> user) {
        for (ClassSyntax userClass : user) {
            this.numVariable += userClass.getListVariable().size();
            this.numComments += userClass.getListComments().size();
            this.numMethods += userClass.getListMethods().size();
            for (Method element : userClass.getListMethods()) {
                List<Variable> ListVariableListMethods = element.getListParameters();
                this.numVariable += ListVariableListMethods.size();
            }
        }
    }
}
