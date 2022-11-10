package lotto.domain;


public class Amount {
    private final static int lottoPrice = 1000;
    private final int inputAmount;

    private int purchasesQuantity;

    Amount(int inputAmount) {
        this.inputAmount = inputAmount;
    }

    public int getPurchasesQuantity() {
        calculatePurchasesQuantity();
        return this.purchasesQuantity;
    }
    private void calculatePurchasesQuantity() {
        int purchasesQuantity = inputAmount / lottoPrice;
        if (inputAmount % lottoPrice != 0) {
            throw new IllegalArgumentException();
        }
        this.purchasesQuantity = purchasesQuantity;
    }


    public double calculateEarningRate() {
        return 0;
    }
}
