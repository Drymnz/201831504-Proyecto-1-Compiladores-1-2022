package com.cunoc.Analyzer;

import com.cunoc.JFlex_Cup.Token;
import com.cunoc.JFlex_Cup.Java.repetition.Method;
import com.cunoc.Simulator.SimulatorVariable;

public class ConvertirJSon {

    private final String CLASS = "Clases";
    private final String VARIBLE = "Variables";
    private final String METHODS = "Metodos";
    private final String COMMENTS = "Comentarios";

    private final String NAME = "Nombre";
    private final String TEXT = "Texto";
    private final String FUNCTION = "Funcion";
    private final String SCORE = "Score";
    private final String TYPE = "Tipo";
    private final String PARAMETERS = "Parametros";

    private final String JUMPLE = "\n";
    private final String QUOTATIONMARKS = "\"";
    private final String TABULATOR = "\t";

    private final String POINT_DOUBLE = ":";
    private final String COMA = ",";
    private final String P_BRACKET = "[";
    private final String C_BRACKET = "]";
    private final String P_KEY = "{";
    private final String C_KEY = "}";

    public String objectJSonString(JSon user) {
        String text = P_KEY;
        int i = 0;
        text += "";
        text += JUMPLE + TABULATOR + SCORE + POINT_DOUBLE + QUOTATIONMARKS + user.getScore() + QUOTATIONMARKS + COMA;
        // class
        text += JUMPLE + TABULATOR + CLASS + POINT_DOUBLE + P_BRACKET;
        for (String element : user.getListNameClass()) {
            text += JUMPLE + TABULATOR + TABULATOR + P_KEY + NAME + POINT_DOUBLE + QUOTATIONMARKS + element
                    + QUOTATIONMARKS
                    + C_KEY;
            i++;
            text += (i > 0 & i < user.getListNameClass().size()) ? COMA : "";
        }
        text += JUMPLE + TABULATOR + TABULATOR + C_BRACKET + COMA;
        i = 0;
        // variable
        text += JUMPLE + TABULATOR + VARIBLE + POINT_DOUBLE + P_BRACKET;
        for (SimulatorVariable element : user.getListVariable()) {
            text += JUMPLE + TABULATOR + TABULATOR + P_KEY;
            text += NAME + POINT_DOUBLE + QUOTATIONMARKS + element.getVariable().getLexeme() + QUOTATIONMARKS + COMA;
            text += TYPE + POINT_DOUBLE + QUOTATIONMARKS + element.getVariable().getType() + QUOTATIONMARKS + COMA;
            text += FUNCTION + POINT_DOUBLE + QUOTATIONMARKS + element.getFind() + COMA + element.getWho()
                    + QUOTATIONMARKS;
            text += C_KEY;
            i++;
            text += (i > 0 & i < user.getListVariable().size()) ? COMA : "";
        }
        text += JUMPLE + TABULATOR + TABULATOR + C_BRACKET + COMA;
        i = 0;
        // Methods
        text += JUMPLE + TABULATOR + METHODS + POINT_DOUBLE + P_BRACKET;
        for (Method element : user.getListMethods()) {
            text += JUMPLE + TABULATOR + TABULATOR + P_KEY;
            text += NAME + POINT_DOUBLE + QUOTATIONMARKS + element.getLexeme() + QUOTATIONMARKS + COMA;
            text += TYPE + POINT_DOUBLE + QUOTATIONMARKS + element.getType() + QUOTATIONMARKS + COMA;
            text += PARAMETERS + POINT_DOUBLE + element.getListParameters().size();
            text += C_KEY;
            i++;
            text += (i > 0 & i < user.getListMethods().size()) ? COMA : "";
        }
        text += JUMPLE + TABULATOR + TABULATOR + C_BRACKET + COMA;
        i = 0;
        // COMMENT
        text += JUMPLE + TABULATOR + COMMENTS + POINT_DOUBLE + P_BRACKET;
        for (Token element : user.getListComments()) {
            text += JUMPLE + TABULATOR + TABULATOR + P_KEY;
            text += TEXT +POINT_DOUBLE+ QUOTATIONMARKS + element.getLexeme() + QUOTATIONMARKS+C_KEY;
            i++;
            text += (i > 0 & i < user.getListComments().size()) ? COMA : "";
        }
        text += JUMPLE + TABULATOR + TABULATOR + C_BRACKET;
        text += JUMPLE + C_KEY;
        return text;
    }
}
