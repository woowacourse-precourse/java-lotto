package lotto.gameSetting;

import  java.util.NoSuchElementException;

public class UserInput {
    public static void moneyNumberCheck(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            System.out.println(ExceptionMessage.NUMBER_EXCEPTION.message());
            throw new NoSuchElementException();
        }
    }
    
    public static void moneyPriceCheck(String money) {
        int checkMoney = Integer.parseInt(money);
        
        if (checkMoney%1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.THOUSAND_EXCEPTION.message());
        }
    }

    public static void winningNumberNumberCheck(String[] winningNumber) {
        try {
            for(int i=0; i<winningNumber.length; i++) {
                Integer.parseInt(winningNumber[i]);    
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_EXCEPTION.message());
        }
    }

    public static void bonusNumberNumberCheck(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_EXCEPTION.message());
        }
    }

    public static void bonusNumberRangeCheck(String bonusNumber) {
        int check = Integer.parseInt(bonusNumber);
        if (check<1 || check>45) {
            throw new IllegalArgumentException(ExceptionMessage.RANGE_EXCEPTION.message());
        }
    }

    public static void bonusNumberOverlapCheck(String bonusNumber, String[] winningNumber) {
        for(int i=0; i<6; i++) {
            if (bonusNumber.equals(winningNumber[i])) {
                throw new IllegalArgumentException(ExceptionMessage.BONUS_OVERLAP_EXCEPTION.message());
            }
        }
    }

    public static void moneyCheck(String money) {
        moneyNumberCheck(money);
        moneyPriceCheck(money);
    }

    public static void bonusNumberCheck(String bonusNumber, String[] winningNumber) {
        bonusNumberNumberCheck(bonusNumber);
        bonusNumberRangeCheck(bonusNumber);
        bonusNumberOverlapCheck(bonusNumber, winningNumber);
    }
}
