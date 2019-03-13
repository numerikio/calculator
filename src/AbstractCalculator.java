import analyzers.DataAnalyzer;
import in.DataIn;
import out.DataOut;

abstract class AbstractCalculator {

    DataAnalyzer dataAnalyzer;
    DataIn dataIn;
    DataOut dataOut;

    public AbstractCalculator(DataAnalyzer dataAnalyzer, DataIn dataIn, DataOut dataOut) {
        this.dataAnalyzer = dataAnalyzer;
        this.dataIn = dataIn;
        this.dataOut = dataOut;
    }

    void run() {
        dataOut.useData(dataAnalyzer.getDataHandler(dataIn.getData()).getResult());
    }

}
