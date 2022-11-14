package lotto.controller;

import java.util.function.Predicate;

public class Money {
    private final int money;

    public Money(String money) throws IllegalArgumentException {
        validateNumber(money);
        int purchaseMoney = Integer.parseInt(money);
        validateDividable(purchaseMoney);
        this.money = purchaseMoney;
    }
    public int calculatePurchaseNumber() {
        return money/1000;
    }

    private void validateDividable(int money) throws IllegalArgumentException {
        if (money%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 돈을 입력해주세요.");
        }
    }

    private void validateNumber(String money) throws IllegalArgumentException {
        Boolean hasNoneDigit = money.chars()
                .mapToObj(e->(char)e)
                .anyMatch(Predicate.not(Character::isDigit));
        if (hasNoneDigit) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    public static Money from(String money) {
        return new Money(money);
    }
}
