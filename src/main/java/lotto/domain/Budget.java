package lotto.domain;

import lotto.UI.ErrorMessage;

import java.util.function.Predicate;

public class Budget {
    private final int budgetNumber; // 구입한 로또 갯수

    public Budget(String money) {
        isMoneyValid(money);
        int budget = Integer.parseInt(money);
        isMoneyDividable(budget);
        this.budgetNumber = budget / 1000;
    }

    public static Budget from(String money) {
        return new Budget(money);
    }

    private void isMoneyValid(String money) throws IllegalArgumentException {
        Boolean notDigit = money.chars().mapToObj(obj -> (char) obj).anyMatch(Predicate.not(Character::isDigit));
        if (notDigit) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER.getValue());
        }
    }

    private void isMoneyDividable(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MULTIPLE_OF_1000.getValue());
        }
    }

    public int getBudgetNumber() { // getter
        return this.budgetNumber;
    }


}
