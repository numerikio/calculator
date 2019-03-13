import analyzers.InputDataAnalyzer;
import in.ConsoleInput;
import out.ConsoleOutput;

public class ClientApp {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new InputDataAnalyzer(), new ConsoleInput(), new ConsoleOutput());
        calculator.run();
    }
}
