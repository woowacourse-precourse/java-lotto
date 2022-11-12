package lotto.model;

public class Amount {
    private static final String WRONG_PURCHASE_AMOUNT = "[ERROR] 1000 단위만 입력할 수 있습니다.";
    private static final int LOTTO_AMOUNT = 1000;
    private final int purchaseAmount;

    public Amount(int purchaseAmount) {
        checkThousand(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void checkThousand(int inputAmount) {
        if (inputAmount % 1000 != 0) {
            throw new IllegalArgumentException(WRONG_PURCHASE_AMOUNT);
        }
    }

    public int getLottoCount() {
        return purchaseAmount / LOTTO_AMOUNT;
    }
}
