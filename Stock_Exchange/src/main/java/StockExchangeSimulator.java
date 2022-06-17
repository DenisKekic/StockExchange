public class StockExchangeSimulator{
    private int dowJones = 16000;
    private int atx = 2000;
    private boolean jonesRisingFalling = false;
    private boolean atxRisingFalling = false;

    public StockExchangeSimulator(boolean jonesRising, boolean atxRising) {
        this.jonesRisingFalling = jonesRising;
        this.atxRisingFalling = atxRising;
    }

    public void setJonesRising(boolean jonesRising) {
        this.jonesRisingFalling = jonesRising;
    }

    public void setAtxRising(boolean atxRising) {
        this.atxRisingFalling = atxRising;
    }

    public int getDowJones() {
        if(jonesRisingFalling){
            dowJones = dowJones + (int)( Math.random() * 2 + 1);
        }else{
            dowJones = dowJones - (int)( Math.random() * 2 + 1);
        }
        return dowJones;
    }

    public int getATX() {
        if(atxRisingFalling){
            atx = atx + (int)( Math.random() * 2 + 1);
        }else{
            atx = atx - (int)( Math.random() * 2 + 1);
        }
        return atx;
    }
}
