package lotto.domain;

public class LottoQuantityCalculation {
    private final int purchaseAmount;

    public LottoQuantityCalculation(int numbers) {
        this.purchaseAmount = numbers;
    }

    public int purchaseQuantity() {
        return purchaseAmount / 1000;
    }
}
