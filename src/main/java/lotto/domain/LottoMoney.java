package lotto.domain;

import static lotto.domain.Error.*;
import static lotto.domain.Number.*;

public class LottoMoney {
    private int money;
    private int quantity;

    public void inputMoney(String input) {
        validateNumber(input);
        money = toInt(input);
        validateDividedNumber();
        quantity = divideThousand();
    }

    private void validateNumber(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NUMBER.getMessage());
        }
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    private void validateDividedNumber() {
        if ((money % THOUSAND.getNumber() != ZERO.getNumber()) || (divideThousand() == ZERO.getNumber())) {
            throw new IllegalArgumentException(MONEY.getMessage());
        }
    }

    private int divideThousand() {
        return money / THOUSAND.getNumber();
    }

    public int getMoney() {
        return money;
    }

    public int getLottoQuantity() {
        return quantity;
    }
}
