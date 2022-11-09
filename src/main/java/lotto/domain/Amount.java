package lotto.domain;


public class Amount {
    private final static int lottoAmount = 1000;

    public int calculateNumberOfPurchases(int inputMoney) {
        int numberOfPurchases = inputMoney / lottoAmount;
        if (inputMoney % lottoAmount != 0) {
            throw new IllegalArgumentException();
        }
        return numberOfPurchases;
    }

    public double calculateEarningRate() {
        return 0;
    }
}
