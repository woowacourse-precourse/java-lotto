package domain;

import camp.nextstep.edu.missionutils.Console;

import static values.Constants.Digit.LOTTO_PRICE;
import static values.Constants.Error.MONEY_VALUE_ERROR_MESSAGE;

public class Money {
    private int money;

    public Money(int money){
        validateMoney(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public static Money inputMoney(){
        String money = Console.readLine();
        return changeToMoney(money);
    }

    private static void validateMoney(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    private static Money changeToMoney(String inputValue){
        try{
            int money = Integer.parseInt(inputValue);
            return new Money(money);
        } catch(Exception e) {
            throw new IllegalArgumentException(MONEY_VALUE_ERROR_MESSAGE);
        }
    }
}
