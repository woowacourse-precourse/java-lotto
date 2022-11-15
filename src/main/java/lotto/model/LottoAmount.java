package lotto.model;

public class LottoAmount {
    private final int amount;
    private final String SHORT_AMOUNT = "[ERROR] 구입금액이 부족합니다.";
    private final String REMAIN_AMOUNT = "[ERROR] 남는 금액이 존재합니다.";

    public LottoAmount(int purchaseAmount) {
        validateEnoughMoney(purchaseAmount);
        validateChangeIsZero(purchaseAmount);
        this.amount = purchaseAmount;
    }

    public int quantityOfLotto(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    private void validateEnoughMoney(int purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException(SHORT_AMOUNT);
        }
    }

    private void validateChangeIsZero(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(REMAIN_AMOUNT);
        }
    }
}