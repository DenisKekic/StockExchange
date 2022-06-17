public class StockTestDriver {
    public static void main(String[] args) {
        StockExchangeDataCollector stockExchangeDataCollector = new StockExchangeDataCollector(new StockExchangeSimulator(false,true));
        Thread thread = new Thread(stockExchangeDataCollector);
        thread.start();

        stockExchangeDataCollector.addEvaluator(new TrendEvaluatorATX(stockExchangeDataCollector, 20));
    }
}
