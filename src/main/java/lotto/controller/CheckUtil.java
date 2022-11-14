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

    public static void checkIsValidWinningNumber(List<Integer> winning) throws IllegalArgumentException{
        for(int num:winning){
            if(num<1 || num>45){
                throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_ERROR_MESSAGE.getMessage());
            }
        }
    }

    public static void checkIsValidBonusNumber(int bonus) throws IllegalArgumentException{
        if(bonus<1 || bonus>45){
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }

    public static void checkIsDuplicatedNumbers(List<Integer> winning,int bonus){
        for(int num:winning) {
            if (num == bonus) throw new IllegalArgumentException(WINNING_BONUS_NUMBER_DUPLICATED_ERROR_MESSAGE.getMessage());
        }
    }
}
