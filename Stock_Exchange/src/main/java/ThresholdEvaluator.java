public class ThresholdEvaluator implements Evaluator{

    private int startAtx;
    private int startDowJones;

    private int currentAtx;
    private int currentJohn;

    private boolean first = true;
    private StockExchangeDataCollector stockExchangeDataCollector;

    public ThresholdEvaluator(StockExchangeDataCollector stockExchangeDataCollector) {
        this.stockExchangeDataCollector = stockExchangeDataCollector;
    }

    @Override
    public void inform() {
        getFilled();
        informAboutCurrentCircumstances();
    }

    private void getFilled(){
        if (first){
            startAtx = stockExchangeDataCollector.getAtxValue();
            startDowJones = stockExchangeDataCollector.getDowJonesValue();
            first = false;
        }else{
            currentAtx = stockExchangeDataCollector.getAtxValue();
            startDowJones = stockExchangeDataCollector.getDowJonesValue();
        }
    }

    private void informAboutCurrentCircumstances(){
        if(currentAtx > startAtx * 1.05){
            System.out.println("ATX: Die Obergrenze wurde erreicht!");
        }else if(currentAtx < startAtx * 0.95){
            System.out.println("ATX: Die Untergrenze wurde erreicht!");
        }

        if(currentJohn > startDowJones * 1.05){
            System.out.println("DowJones: Die Obergrenze wurde erreicht!");
        }else if(currentJohn < startDowJones * 0.95){
            System.out.println("DowJones: Die Untergrenze wurde erreicht!");
        }
    }
}
