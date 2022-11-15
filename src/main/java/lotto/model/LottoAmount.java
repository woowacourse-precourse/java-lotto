package lotto.model;

public class LottoAmount {
    private final int amount;

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
            throw new IllegalArgumentException("[ERROR] 구입금액이 부족합니다.");
        }
    }

    private void validateChangeIsZero(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 남는 금액이 존재합니다.");
        }
    }
}