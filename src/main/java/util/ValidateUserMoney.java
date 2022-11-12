package util;

import constant.ErrorMessage;
import java.util.stream.IntStream;
import view.OutputView;

public class ValidateUserMoney {

    private static final int EXCEPTION_CODE=-1;
    private static final char MIN_NUMBER_CHAR ='0';
    private static final char MAX_NUMBER_CHAR ='9';
    private static final int CURRENCY_UNIT=1000;
    static int userMoney;

    public static boolean validateMoney(String input_money){
        if (checkProcessIsNumber(input_money)) {
            return false;
        }
        if (checkProcessIsCorrectMoney(input_money)) {
            return false;
        }
        return true;
    }

    private static boolean checkProcessIsCorrectMoney(String input_money){
        try{
            isCorrectMoney(Integer.parseInt(input_money));
        }
        catch (IllegalArgumentException e){
            OutputView.printException(e);
            return true;
        }
        return false;
    }

    private static boolean checkProcessIsNumber(String input_money){
        try {
            isNumber(input_money);
        }
        catch(IllegalArgumentException e){
            OutputView.printException(e);
            return true;
        }
        return false;
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
