package util;

import constant.ErrorMessage;
import java.util.stream.IntStream;
import view.OutputView;

public class ValidateUserMoney {

    private static final char MIN_NUMBER_CHAR ='0';
    private static final char MAX_NUMBER_CHAR ='9';
    private static final int CURRENCY_UNIT=1000;
    static int userMoney;

    public static boolean validateMoney(String input_money){
        checkProcessIsNumber(input_money);

        checkProcessIsCorrectMoney(input_money);

        checkIsNone(input_money);

        return true;
    }

    private static void checkIsNone(String input_money) {
        isNoMoney(Integer.parseInt(input_money));
    }



    private static void checkProcessIsCorrectMoney(String input_money){
        isCorrectMoney(Integer.parseInt(input_money));

    }

    private static void checkProcessIsNumber(String input_money){
        isNumber(input_money);


    }

    private static void isNoMoney(int parseInt) {
        if(parseInt==0){
            throw new IllegalArgumentException(ErrorMessage.ERROR_NO_MONEY.getMessage());
        }
    }

    private static void isCorrectMoney(int money){
        if(money % CURRENCY_UNIT>0){
            throw new IllegalArgumentException(ErrorMessage.ERROR_INCORRECT_MONEY.getMessage());
        }
    }

    private static void isNumber(String input_money){
        IntStream chars = input_money.chars();
        if(chars.anyMatch(c ->  (c< MIN_NUMBER_CHAR || c> MAX_NUMBER_CHAR))){
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMBER.getMessage());
        }
    }
}
