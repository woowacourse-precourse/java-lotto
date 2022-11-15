package lotto.domain;

import static lotto.util.NumberValidator.checkWrongLottoAmount;

public class Purchase {

    private static final int LOTTO_PRICE = 1_000;

    private final int amount;
    private final int count;

    public Purchase(int amount) {
        validate(amount);
        this.amount = amount;
        this.count = amount / LOTTO_PRICE;
    }

    private void validate(int amount) {
        checkWrongLottoAmount(amount, LOTTO_PRICE);
    }

    public void printCount() {
        System.out.println(count + "개를 구매했습니다.");
    }

    public int getAmount() {
        return amount;
    }

    public int getCount() {
        return count;
    }
}
