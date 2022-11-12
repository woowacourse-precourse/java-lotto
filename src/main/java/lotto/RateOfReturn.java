package lotto;

public class RateOfReturn {
    public static double makeRateOfReturn(int purchasePrice,int winningPrice){
        double dived = (double)winningPrice/purchasePrice;
        double rounded = Math.round(dived * 1000);
        double rateOfReturn =  rounded/10;
        return rateOfReturn;
    }
}
