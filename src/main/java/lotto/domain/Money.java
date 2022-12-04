package lotto.domain;

public class Money {

    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (!isNaturalNumber(money)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 양수여야 합니다.");
        }

        if (!isDividedByLottoPrice(money)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 로또 금액의 배수여야 합니다.");
        }
    }

    private boolean isNaturalNumber(int money) {
        return money > 0;
    }

    private boolean isDividedByLottoPrice(int money) {
        return money % Config.LOTTO_PRICE == 0;
    }

    public int getAmount() {
        return money / Config.LOTTO_PRICE;
    }

    public float getProfitRate(float profit) {
        return profit / money;
    }
}
