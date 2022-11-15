package lotto.calculation;

public class LottoPurchase {
    public static int getPurchaseCount(int amount) {
        int lottoPrice= 1000;
        int count = amount / lottoPrice;
        return count;
    } // calculation
}// end class
