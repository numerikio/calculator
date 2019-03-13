package handlers;

import java.util.List;

public abstract class MainDataHandler implements DataHandler {
    private List<String> strings;

    public MainDataHandler(List<String> strings) {
        this.strings = strings;
    }

    @Override
    public String getResult() {
        do {
            getProcedure(strings);
        } while (strings.size() > 1);
        return strings.get(0);
    }

    private List<String> getProcedure(List<String> strings) {
        do {
            getMathPriority(strings, "*", "/");
        } while (strings.contains("*") || strings.contains("/"));
        do {
            getMathPriority(strings, "+", "-");
        } while (strings.contains("+") || strings.contains("-"));
        return strings;
    }

    private List<String> getMathPriority(List<String> strings, String mathSing1, String mathSing2) {
        Number n = null;
        for (int i = 1; i < strings.size(); i += 2) {
            if (strings.get(i).equals(mathSing1) || strings.get(i).equals(mathSing2)) {
                {
                    n = getResultMathOperation(strings.get(i - 1), strings.get(i + 1), strings.get(i));
                    return getCatList(strings, n, i);
                }
            }
        }
        return null;
    }

    private List<String> getCatList(List<String> strings, Number number, int a) {
        strings.remove(a + 1);
        strings.add(a + 1, String.valueOf(number));
        strings.remove(a);
        strings.remove(a - 1);
        return strings;
    }

    abstract protected Number getResultMathOperation(String a, String b, String math);
}
