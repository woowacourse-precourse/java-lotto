package lotto.domain;

public class Money {

    public static final int PRICE_OF_ONE_TIME_LOTTO = 1000;

    private final int amount;

    public Money(int amount) {
        validationInputAmount(amount);
        this.amount = amount;
    }

    private void validationInputAmount(int inputAmount) {
        if (inputAmount % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1000원 단위로만 가능합니다.");
        }
        if (inputAmount <= 0) {
            throw new IllegalArgumentException("금액은 자연수만 입력해주세요!");
        }
    }

    public int getAmount() {
        return amount;
    }

    public int getNumberOfLottoGame() {
        return this.amount / PRICE_OF_ONE_TIME_LOTTO;
    }
}
