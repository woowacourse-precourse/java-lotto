package domain;

import exception.MoneyExceptionType;

public class UserMoney {

    private final int THOUSAND = 1000;
    private String input;
    private int money;

    public int getMoney() {
        return money;
    }

    public void isDivideThousand(int money){
        if(money % THOUSAND != 0){
            throw new IllegalArgumentException(MoneyExceptionType.NOT_THOUSAND_MONEY.getErrorMessage());
        }
    }

    public void notNumber(String input){
        for (int i = 0; i < input.length(); i++) {
            int num = input.length();
            if(num < 48 || num > 57){
                throw new IllegalArgumentException(MoneyExceptionType.NO_NUMBER_MONEY.getErrorMessage());
            }
        }
    }

    public void negativeNumber(int money){
        if(money < 0){
            throw new IllegalArgumentException(MoneyExceptionType.NOT_MONEY_NEGATIVE.getErrorMessage());
        }
    }
}
