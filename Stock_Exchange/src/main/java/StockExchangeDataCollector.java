import java.util.LinkedList;
import java.util.List;

public class StockExchangeDataCollector implements Runnable{

    private List<Evaluator> list = new LinkedList<>();

    StockExchangeSimulator stockExchangeSimulator;
    private int dowJonesValue;
    private int atxValue;

    public StockExchangeDataCollector(StockExchangeSimulator stockExchangeSimulator) {
        this.stockExchangeSimulator = stockExchangeSimulator;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()){
            updateValues();
            informEvaluators();
            System.out.println("Values Updated");
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateValues(){
        this.dowJonesValue = stockExchangeSimulator.getDowJones();
        this.atxValue = stockExchangeSimulator.getATX();
    }

    private void informEvaluators(){
        for(Evaluator e : list){
            e.inform();
        }
    }

    public int getDowJonesValue() {
        return dowJonesValue;
    }

    public int getAtxValue() {
        return atxValue;
    }

    public void addEvaluator(Evaluator e) {
        list.add(e);
    }

    public void removeEvaluator(Evaluator e){
        list.remove(e);
    }
}
