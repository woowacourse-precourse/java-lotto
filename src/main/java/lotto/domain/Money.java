package lotto.domain;

public class Money {
    private final String money;

    public Money(String money) {
        this.money = money;
    }

    private boolean isNotNumeric(String money) {
        return !money.chars().allMatch(Character::isDigit);
    }
}
