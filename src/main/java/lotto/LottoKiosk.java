package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class LottoKiosk {
    private final int LOTTO_PRICE = 1000;

    private String moneyInput;
    private long money;
    private long howMany;

    public void insertMoney() {
        askHowMuch();
        moneyInserted();
        validateMoneyInput();
        chargeMoney();
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

    void chargeMoney() {
        money = Long.parseLong(moneyInput);
    }

    void validateMoney() {
        if (this.money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.DIVIDE_DISABLE.message);
        }
    }

    long showInsertedMoney() {
        return this.money;
    }

    void calculateLottoAmount() {
        this.howMany = money / LOTTO_PRICE;
    }

    long showHowMany() {
        return this.howMany;
    }

    void showHowManyLotto() {
        System.out.println(howMany + Messages.HOW_MANY_SOLD.message);
    }
}
