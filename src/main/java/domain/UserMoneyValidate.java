package domain;

import exception.MoneyExceptionType;

public class UserMoneyValidate {

    private final int THOUSAND = 1000;
    private String input;

    public int validateGetMoney(String input) {
        notNumber(input);
        int user_money = convertStringToInt(input);
        negativeNumber(user_money);
        isDivideThousand(user_money);

        return user_money;
    }

    public int convertStringToInt(String input){
        int convert_num = Integer.parseInt(input);
        return convert_num;
    }

    public void isDivideThousand(int money){
        if(money % THOUSAND != 0){
            throw new IllegalArgumentException(MoneyExceptionType.NOT_THOUSAND_MONEY.getErrorMessage());
        }
    }

    public void notNumber(String input){
        for (int i = 0; i < input.length(); i++) {
            int num = input.charAt(i);
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
