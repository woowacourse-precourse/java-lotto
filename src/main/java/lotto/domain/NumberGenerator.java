package lotto.domain;

public class NumberGenerator {

    private final int money;
    private final int quantity;

    public NumberGenerator(int money) {
        validate(money);
        this.money = money;
        this.quantity = this.money / 1000;
    }

    private void validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }


}
