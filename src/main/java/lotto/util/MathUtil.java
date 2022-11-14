package lotto.util;

import static lotto.model.GameNumber.THOUSAND;

public class MathUtil {
    public double makeRateOfReturn(int purchasePrice,int totalPrice){
        double dived = (double)totalPrice/purchasePrice;
        double rounded = Math.round(dived * 1000);
        double rateOfReturn =  rounded/10;
        return rateOfReturn;
    }

    public int divide(int inputPurchasePrice){
        int divided = Math.floorDiv(inputPurchasePrice,THOUSAND.getNumber());
        return divided;
    }
}
