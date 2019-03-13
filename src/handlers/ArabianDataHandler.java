package handlers;

import java.util.List;

public class ArabianDataHandler extends MainDataHandler {
    public ArabianDataHandler(List<String> strings) {
        super(strings);
    }

    @Override
    protected Number getResultMathOperation(String a, String b, String math) {
        switch (math) {
            case "+":
                return Double.valueOf(a) + Double.valueOf(b);
            case "-":
                return Double.valueOf(a) - Double.valueOf(b);
            case "*":
                return Double.valueOf(a) * Double.valueOf(b);
            case "/":
                return Double.valueOf(a) / Double.valueOf(b);
        }
        return null;
    }
}
