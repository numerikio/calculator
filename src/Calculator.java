import analyzers.DataAnalyzer;
import in.DataIn;
import out.DataOut;

public class Calculator extends AbstractCalculator {
    public Calculator(DataAnalyzer dataAnalyzer, DataIn dataIn, DataOut dataOut) {
        super(dataAnalyzer, dataIn, dataOut);
    }
}
