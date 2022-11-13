package domain;

import camp.nextstep.edu.missionutils.Console;

import static values.Constants.Digit.LOTTO_PRICE;

public class Money {
    private int money;

    public Money(int money){
        validateMoney(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private static void validateMoney(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }
}
