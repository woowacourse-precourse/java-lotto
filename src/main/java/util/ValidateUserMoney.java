package util;

import constant.ErrorMessage;
import java.util.stream.IntStream;
import view.ExceptionInfo;

public class ValidateUserMoney {
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
            ExceptionInfo.printException(e);
            return true;
        }
        return false;
    }

    private static boolean checkProcessIsNumber(String input_money){
        try {
            isNumber(input_money);
        }
        catch(IllegalArgumentException e){
            ExceptionInfo.printException(e);
            return true;
        }
        return false;
    }

    private static void isCorrectMoney(int money){
        if(money %1000>0){
            throw new IllegalArgumentException(ErrorMessage.ERROR_INCORRECT_MONEY.getMessage());
        }
    }

    private static void isNumber(String input_money){
        IntStream chars = input_money.chars();
        if(chars.anyMatch(c ->  (c<'0' || c>'9'))){
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMBER.getMessage());
        }
    }
}
