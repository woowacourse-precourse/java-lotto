package lotto.domain;

public class Money {
    private long money;

    public Money(String input) {
        this.money = validate(input);
    }

    private long validate(String input) {
        long money;
        try {
            money = Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_NOT_INTEGER.get());
        }
        if (money < 1000) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_UNDER_1000.get());
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_NOT_DIVIDED_BY_1000.get());
        }
        return money;
    }

    public long getLottoCount() {
        return this.money / 1000;
    }

    public long getMoney() {
        return this.money;
    }
}
