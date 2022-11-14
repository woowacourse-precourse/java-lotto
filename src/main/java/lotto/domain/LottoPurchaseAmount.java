package lotto.domain;

public class LottoPurchaseAmount {
    private static final String WRONG_PURCHASE_AMOUNT= "[ERROR] 1000원 단위로 입력하셔야 합니다.";

    private final int purchaseAmount;

    public LottoPurchaseAmount(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(int purchaseAmount) {
        if ((purchaseAmount % Lotto.LOTTO_PRICE) > 0) {
            throw new IllegalArgumentException(WRONG_PURCHASE_AMOUNT);
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
