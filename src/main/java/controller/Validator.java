package controller;

import resources.Error;
import java.util.Arrays;

public class Validator {
    public static final int ONE_THOUSAND = 1000;
    public static final int LOTTO_SIZE = 6;
    public static final int BONUS_SIZE = 1;

    public static int isNumber(String purchasingMoney,Error error) {
        for(int i=0; i < purchasingMoney.length(); i++) {
            if (!Character.isDigit(purchasingMoney.charAt(i))) {
                throw new IllegalArgumentException(error.getMsg());
            }
        }
        return Integer.parseInt(purchasingMoney);
    }

    public static void isDivideBy1000(int money,Error error) {
        if(money % ONE_THOUSAND != 0) {
            throw new IllegalArgumentException(error.getMsg());
        }
    }

    public static void validateWinningNumber(String[] pureNumber) {
        for (String s : pureNumber) {
            isNumeric(s, Error.NUMBER);
            isCorrectRange(s,Error.RANGE);
        }
        isCorrectSize(pureNumber,Error.SIZE);
    }

    public static int validateBonusNumber(String bonusNumber) {
        isNumeric(bonusNumber, Error.NUMBER);
        isCorrectRange(bonusNumber,Error.RANGE);
        InputOnlyOne(bonusNumber, Error.ONE_SIZE);
        return Integer.parseInt(bonusNumber);
    }

    public static void isNumeric(String s, Error error) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            throw new IllegalArgumentException(error.getMsg());
        }
    }

    public static void isCorrectRange(String s, Error error) {
        int number = Integer.parseInt(s);
        if (number < 1  || number > 45) {
            throw new IllegalArgumentException(error.getMsg());
        }
    }

    public static void isCorrectSize(String[] numbers,Error error) { // 랜덤 로또 번호의 길이가 6인지 보는 것이다.
        if (Arrays.stream(numbers).count() != LOTTO_SIZE) {
            throw new IllegalArgumentException(error.getMsg());
        }
    }

    public static void InputOnlyOne(String number, Error error) {
        if (number.length() != BONUS_SIZE) {
            throw new IllegalArgumentException(error.getMsg());
        }
    }
}
