import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class TrendEvaluatorATX implements Evaluator{

    private StockExchangeDataCollector stockExchangeDataCollector;
    private Queue<Integer> stockValues = new LinkedBlockingQueue<>();
    private int QueueSize;

    public TrendEvaluatorATX(StockExchangeDataCollector stockExchangeDataCollector, int queueSize) {
        this.stockExchangeDataCollector = stockExchangeDataCollector;
        QueueSize = queueSize;
    }

    @Override
    public void inform() {
        fillQueue(stockExchangeDataCollector.getAtxValue());
        evaluate();
    }

    private void fillQueue(int i){
        if(stockValues.size() >= QueueSize){
            stockValues.remove();
        }
        stockValues.add(i);
    }

    private void evaluate(){
        Queue<Integer> stockValuesQueue = new LinkedBlockingQueue<>(stockValues);

        stockValuesQueue.remove();

        int rising = 0;
        int falling = 0;
        for(int i : stockValues){
            try{
                if(i < stockValuesQueue.peek()){
                    rising ++;
                }else if(i > stockValuesQueue.peek()){
                    falling++;
                }
            }catch(Exception e){

            }finally {
                stockValuesQueue.poll();
            }
        }
        if(rising>=9){
            System.out.println("Trend is rising");
        }else if(falling>=9){
            System.out.println("Trend is falling");
        }
    }
}
