package in;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements DataIn {

    private String exampleArabian = "567 / 445 + 45.5 * 23 - 0.01";
    private String exampleRoman = "XXXI + DCCLIV / LIV - XIX * DCCLXXVII";
    private String linkomanConverter = "http://graecolatini.bsu.by/htm-different/num-converter-roman.htm";
    private String line = "----------------------------------------";
    private String message = "( there must be a space between characters and numbers! )";
    private String mathShar = "\"+\" \"-\" \"*\" \"/\"";

    @Override
    public List<String> getData() {
        printInfo();
        return getText();
    }

    private List<String> getText() {
        print("Input mathematical expression, please:");
        Scanner scanner = new Scanner(System.in);
        return new ArrayList(Arrays.asList(scanner.nextLine().split(" ")));
    }

    private void printInfo() {
        print(line);
        print("Input examples: ");
        print(exampleArabian + "\t or \t" + exampleRoman + "\t" + "(link to converter: " + linkomanConverter + ")");
        print("only : "+mathShar);
        print(message);
        print(line);
    }

    private void print(String string) {
        System.out.println(string);
    }
}

