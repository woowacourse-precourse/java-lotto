package lotto.domain;


public class Amount {
    private final static int lottoPrice = 1000;

    public int calculatePurchasesQuantity(int inputAmount) {
        int purchasesQuantity = inputAmount / lottoPrice;
        if (inputAmount % lottoPrice != 0) {
            throw new IllegalArgumentException();
        }
        return purchasesQuantity;
    }

    public double calculateEarningRate() {
        return 0;
    }
}
