package user;

import camp.nextstep.edu.missionutils.Console;
import ui.View;

public class Money {
    private final boolean VALID = true;
    private final int BASE_MONEY = 1000;
    private int money;

    public Money() {
        View.promptSeedMoney();
        int money = inputToInteger();
        if (isMoneyPositive(money) && isMoneyThousandMultiple(money)) {
            this.money = money;
        }
    }

    public Money(int money) {
        if (isMoneyPositive(money) && isMoneyThousandMultiple(money)) {
            this.money = money;
        }
    }

    private int inputToInteger() {
        String input = Console.readLine();
        checkInputNull(input);
        checkInputNumber(input);
        return Integer.parseInt(input);
    }

    private void checkInputNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkInputNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean isMoneyPositive(int money) {
        return money >= 0;
    }

    public boolean isMoneyThousandMultiple(int money) {
        return money % BASE_MONEY == 0;
    }

    public void addMoney(int money) {
        if (isMoneyPositive(money) == VALID) {
            this.money += money;
        }
    }

    public int getMoney() {
        return money;
    }
}
