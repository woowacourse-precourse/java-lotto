package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoKiosk {
    private final int DIVIDE = 1000;
    private String moneyInput;
    private long money;

    public void insert() {
        askHowMuch();
        moneyInserted();
        validateMoneyInput();
        moneyCharged();
        validateMoney();
    }

    void askHowMuch() {
        System.out.println(Messages.REQUEST_MONEY.message);
    }

    void moneyInserted() {
        this.moneyInput = Console.readLine();
    }

    void validateMoneyInput() {
        this.moneyInput.chars().forEach(o -> {
            if (!Character.isDigit(o)) {
                throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.message);
            }
        });
    }

    void moneyCharged(){
        money = Long.parseLong(moneyInput);
    }

    void validateMoney() {
        if (this.money % DIVIDE != 0) {
            throw new IllegalArgumentException(ErrorMessage.DIVIDE_DISABLE.message);
        }
    }

    long showInsertedMoney() {
        return this.money;
    }
}
