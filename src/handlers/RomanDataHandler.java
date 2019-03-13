package handlers;

import handlers.parsers.Parser;

import java.util.List;

public class RomanDataHandler extends MainDataHandler {
    Parser parser;

    public RomanDataHandler(List<String> strings, Parser parser) {
        super(strings);
        this.parser = parser;
    }

    @Override
    protected Number getResultMathOperation(String a, String b, String math) {

        switch (math) {
            case "+":
                return Double.valueOf(getNolmalString(a)) + Double.valueOf(getNolmalString(b));
            case "-":
                return Double.valueOf(getNolmalString(a)) - Double.valueOf(getNolmalString(b));
            case "*":
                return Double.valueOf(getNolmalString(a)) * Double.valueOf(getNolmalString(b));
            case "/":
                return Double.valueOf(getNolmalString(a)) / Double.valueOf(getNolmalString(b));
        }
        return null;
    }

    private String getNolmalString(String s) {
        try {
            Double.valueOf(s);
        } catch (Exception e) {
            return String.valueOf(parser.getNumber(s));
        }
        return s;
    }
}
