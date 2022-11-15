package lotto.Domain;

public class PurchasingLotto {

    private int purchase;
    private int amountOfLotto;
    private final String ERROR_DEVISION_EXCEPTION = "[ERROR] 구입 금액이 1000원으로 나누어 떨어지지 않습니다.";

    public PurchasingLotto(int purchase) {
        devisionValid(purchase);
        this.amountOfLotto = calculateNumberOfLotto(purchase);
        this.purchase = purchase;
    }

    public int calculateNumberOfLotto(int purchasingAmount) {
        int numberOfLotto = purchasingAmount / 1000;
        return numberOfLotto;
    }

    private void devisionValid(int purchase) {
        if (purchase % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_DEVISION_EXCEPTION);
        }
    }

    public int getPurchase() {
        return this.purchase;
    }
}
