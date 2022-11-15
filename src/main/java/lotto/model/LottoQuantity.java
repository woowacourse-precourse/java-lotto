package lotto.model;

public class LottoQuantity {
    private final int quantity;

    public LottoQuantity(int purchaseAmount) {
        validateEnoughMoney(purchaseAmount);
        validateChangeIsZero(purchaseAmount);
        this.quantity = quantityOfLotto(purchaseAmount);
    }

    static void validateEnoughMoney(int purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입금액이 부족합니다.");
        }
    }

    static void validateChangeIsZero(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 남는 금액이 존재합니다.");
        }
    }

    static int quantityOfLotto(int purchaseAmount) {
        return purchaseAmount / 1000;
    }
}