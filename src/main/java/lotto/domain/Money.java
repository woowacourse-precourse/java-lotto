package lotto.domain;

public class Money {
    private int money;

    public Money(String input) {
        validate(input);
        this.money = Integer.parseInt(input);
    }

    private void validate(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ErrorMessages.MONEY_NOT_INTEGER.get());
            }
        }

        int money = Integer.parseInt(input);
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
