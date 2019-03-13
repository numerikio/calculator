package analyzers;

import handlers.DataHandler;

import java.util.List;

public interface DataAnalyzer {
    DataHandler getDataHandler(List<String>strings);
}


