package analyzers;

import analyzers.DataAnalyzer;
import exceptions.InputStringException;
import handlers.ArabianDataHandler;
import handlers.DataHandler;
import handlers.RomanDataHandler;
import handlers.parsers.RomanNumbersParser;

import java.util.List;

public class InputDataAnalyzer implements DataAnalyzer {

    private String[] mathActions = {"+", "-", "*", "/"};

    @Override
    public DataHandler getDataHandler(List<String> strings) {
        try {
            validatinMathStrings(strings);
        } catch (InputStringException e) {
            e.printStackTrace();
            System.exit(400);
        }
        if (allArabian(strings)) {
            return new ArabianDataHandler(strings);

        } else if (allRoman(strings)) {
            return new RomanDataHandler(strings, new RomanNumbersParser());
        } else {
            try {
                throw new InputStringException("Error input string (type of numbers didn't identified)");
            } catch (InputStringException e) {
                e.printStackTrace();
                System.exit(400);
            }
            return null;
        }
    }

    private void validatinMathStrings(List<String> strings) throws InputStringException {
        boolean flag = false;
        for (int i = 1; i < strings.size(); i += 2) {
            for (String s : mathActions
            ) {
                if (strings.get(i).equals(s)) {
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }
            if (!flag) {
                throw new InputStringException("Error of math char - " + strings.get(i));
            }
        }
    }

    private boolean allArabian(List<String> strings) {
        for (int i = 0; i < strings.size(); i += 2) {
            try {
                Double.valueOf(strings.get(i));
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    private boolean allRoman(List<String> strings) {
        for (int i = 0; i < strings.size(); i += 2) {
            try {
                Double.valueOf(new RomanNumbersParser().getNumber(strings.get(i)));
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

}
