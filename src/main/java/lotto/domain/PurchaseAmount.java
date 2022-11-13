package lotto.domain;

public class PurchaseAmount {

    private final int amount;

    public PurchaseAmount(int inputAmount) {
        validate(inputAmount);
        this.amount = inputAmount;
    }

    private void validate(int inputAmount) {
        if(inputAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력한 금액이 1,000원 단위가 아닙니다.");
        }
        if(!isRanged(inputAmount)) {
            throw new IllegalArgumentException("[ERROR] 입력한 금액이 가능한 범위를 벗어났습니다.");
        }
    }

    private static boolean isRanged(int inputAmount) {
        return 0 <= inputAmount && inputAmount <= Integer.MAX_VALUE;
    }

    public int quantity() {
        return this.amount / 1000;
    }
}
