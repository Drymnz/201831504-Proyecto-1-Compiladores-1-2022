package com.cunoc.Analyzer;

import java.util.ArrayList;
import java.util.List;

import com.cunoc.JFlex_Cup.Token;
import com.cunoc.JFlex_Cup.Java.repetition.ClassSyntax;
import com.cunoc.JFlex_Cup.Java.repetition.Method;
import com.cunoc.JFlex_Cup.Java.repetition.Variable;
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
                List<Method> ListMethodONE = classSyntax.getListMethods();
                List<Method> ListMethodTWO = classSyntaxComparar.getListMethods();
                for (Method methodOne : ListMethodONE) {// n3
                    for (Method methodTWO : ListMethodTWO) {
                        if (equivalentMethod(methodOne, methodTWO)) {// n4
                            exportar.getListMethods().add(methodOne);
                        }
                    }
                }
            }
        }
    }

    // n
    private boolean equivalentMethod(Method methodOne, Method methodTWO) {
        if (analyzerNameClass(methodOne.getLexeme(), methodTWO.getLexeme())
                && equivalentParamet(methodOne.getListParameters(), methodTWO.getListParameters())) {
            return true;
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
                List<Variable> ListVariable = classSyntax.getListVariable();
                List<Variable> ListVariableTWO = classSyntaxComparar.getListVariable();
                List<Method> ListVariableMethodTwo = classSyntaxComparar.getListMethods();
                for (Variable variable : ListVariable) {// n3
                    // con los atributos
                    for (Variable variableTWO : ListVariableTWO) {// n4
                        if (equivalentVariable(variable, variableTWO)) {
                            exportar.getListVariable().add(new SimulatorVariable(variable, classSyntax.getName(),
                                    classSyntaxComparar.getName()));
                        }
                    }
                    for (Method method : ListVariableMethodTwo) {// n4
                        List<Variable> ListVariableMethodTWO = method.getListParameters();
                        for (Variable variableTWO : ListVariableMethodTWO) {
                            if (equivalentVariable(variable, variableTWO)) {
                                exportar.getListVariable().add(
                                        new SimulatorVariable(variable, classSyntax.getName(), method.getLexeme()));
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
                List<Token> ListCommentsONE = classSyntax.getListComments();
                List<Token> ListCommentsTWO = classSyntaxComparar.getListComments();
                for (Token tokenONE : ListCommentsONE) {// n3
                    for (Token tokenTWO : ListCommentsTWO) {
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
        return (variable.getLexeme().equals(variableTWO.getLexeme())) && (variable.getType() == variableTWO.getType());
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

    private void conterner(ArrayList<ClassSyntax> user) {
        for (ClassSyntax userClass : user) {
            List<Method> ListMethods = userClass.getListMethods();
            List<Variable> ListVariable = userClass.getListVariable();
            List<Token> ListComments = userClass.getListComments();
            this.numVariable += ListVariable.size();
            this.numComments += ListComments.size();
            this.numMethods += ListVariable.size();
            for (Method element : ListMethods) {
                List<Variable> ListVariableListMethods = element.getListParameters();
                this.numVariable += ListVariableListMethods.size();
            }
        }
    }
}
