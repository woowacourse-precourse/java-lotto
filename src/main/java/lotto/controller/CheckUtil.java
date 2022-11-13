package lotto.controller;

import java.util.List;

import static lotto.model.ErrorMessage.*;
import static lotto.model.GameNumber.THOUSAND;

public class CheckUtil {
    public static int checkIsString(String input) throws IllegalArgumentException{
        try {
            return Integer.valueOf(input);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException(NOT_STRING_ERROR_MESSAGE.getMessage());
        }
    }
    public static void checkIsDivedByTHOUSAND(int price) throws IllegalArgumentException{
        int divided = Math.floorMod(price,THOUSAND.getNumber());
        if(divided != 0){
            throw new IllegalArgumentException(NOT_DIVIDED_BY_THOUSAND_ERROR_MESSAGE.getMessage());
        }
    }

    public static void checkIsValidWinningNumber(List<Integer> winning){
        for(int num:winning){
            if(num<1 || num>45){

            }
        }
    }
}
