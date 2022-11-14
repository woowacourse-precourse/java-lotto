package lotto.domain;

public class Money {

    private int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (!isDividedByLottoPrice(money)) throw new IllegalArgumentException("[ERROR] 구입 금액은 로또 금액의 배수여야 합니다.");
    }

    private boolean isDividedByLottoPrice(int money) {
        return money % Config.LOTTO_PRICE == 0;
    }

    public int getAmount() {
        return money / Config.LOTTO_PRICE;
    }
}
