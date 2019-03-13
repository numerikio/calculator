package out;

import out.DataOut;

import java.util.Arrays;
import java.util.List;

public class ConsoleOutput implements DataOut {

    private String line = "----------------------------------------";

    @Override
    public void useData(String data) {
        print(line);
        print("Result: \t" + getNormalizationString(data));
        print(line);
    }

    private String getNormalizationString(String s) {
        List<String> list = Arrays.asList(s.split("\\."));
        if (list.get(1).equals("0")) {
            return list.get(0);
        }
        return s;
    }

    private void print(String strint) {
        System.out.println(strint);
    }
}
