package lotto;

public class RateOfReturn {
    public double makeRateOfReturn(int purchasePrice,int totalPrice){
        double dived = (double)totalPrice/purchasePrice;
        double rounded = Math.round(dived * 1000);
        double rateOfReturn =  rounded/10;
        return rateOfReturn;
    }
}
