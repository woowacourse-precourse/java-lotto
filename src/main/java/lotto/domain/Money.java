package lotto.domain;

public class Money {
    private int money;

    public Money(String input) {
        validate(input);
        this.money = Integer.parseInt(input);
    }

    private void validate(String input) {
        int money;

        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_NOT_INTEGER.get());
        }

        if (money < 1000) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_UNDER_1000.get());
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_NOT_DIVIDED_BY_1000.get());
        }
    }

    public int getLottoCount() {
        return money / 1000;
    }
}
