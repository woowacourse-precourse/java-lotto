package lotto.domain;

public class PurchaseAmount {

    private long amount;

    public PurchaseAmount(long inputAmount) {
        validate(inputAmount);
        this.amount = inputAmount;
    }

    private void validate(long inputAmount) {
        if(inputAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력한 금액이 1,000원 단위가 아닙니다.");
        }
        if(inputAmount > 228713284800000L) {
            throw new IllegalArgumentException("[ERROR] 입력한 금액이 가능한 범위를 초과하였습니다.");
        }
    }

    public long quantity() {
        return this.amount / 1000;
    }
}
