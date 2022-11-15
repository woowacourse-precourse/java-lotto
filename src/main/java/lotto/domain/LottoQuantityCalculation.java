package lotto.domain;

public class LottoQuantityCalculation {
    private final int purchaseAmount;

    public LottoQuantityCalculation(int numbers) {
        validate(numbers);
        this.purchaseAmount = numbers;
    }

    private void validate(int numbers) {
        if (numbers % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
    }

    public int purchaseQuantity() {
        return purchaseAmount / 1000;
    }
}
