package lotto.exception;

import lotto.message.Constant;
import lotto.message.Error;

import java.util.Collections;
import java.util.List;

public class ExceptionValidation {

    public static int isNumber(String number) {
        try {
            int amount = Integer.parseInt(number);
            return amount;
        } catch (NumberFormatException e) {
            System.out.println(Error.IS_NUMERIC.getMessage());
            return 0;
        }
    }

    public static void validateException(int input) {
        if ((input % Constant.PRICE.getConstant()) != 0) {
            throw new IllegalArgumentException(Error.OUT_OF_RANGE.getMessage());
        }
    }

    public static void inputException(List<Integer> winnningNum) {
        inputsizeException(winnningNum);
        inputduplicateException(winnningNum);
        inputrangeException(winnningNum);
    }

    private static boolean inputsizeException(List<Integer> input) {
        if (Constant.NUMBER_SIZE.getConstant() != Constant.NUMBER_SIZE.getConstant()) {
            throw new IllegalArgumentException(Error.DUPLICATE_NUMBER.getMessage());
        }
        return false;
    }

    private static boolean inputduplicateException(List<Integer> input) {
        for (int i = 0; i < Constant.NUMBER_SIZE.getConstant(); i++) {
            int frequency = Collections.frequency(input, input.get(i));
            if (input.size() == 6 && frequency >= 2) {
                throw new IllegalArgumentException(Error.DUPLICATE_NUMBER.getMessage());
            }
        }
        return false;
    }

    private static boolean inputrangeException(List<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) < Constant.START_NUMBER.getConstant() || input.get(i) > Constant.END_NUMBER.getConstant()) {
                throw new IllegalArgumentException(Error.INVALID_SIZE.getMessage());
            }
        }
        return false;
    }

    public static void bonusException(int bonus, List<Integer> Winning) {
        checkDuplication(bonus, Winning);
        checkBonusSize(bonus);
    }

    private static boolean checkDuplication(int bonus, List<Integer> Winning) {
        for (int i = 0; i < Constant.NUMBER_SIZE.getConstant(); i++) {
            if (Winning.contains(bonus)) {
                throw new IllegalArgumentException(Error.ANOTHER_NUM.getMessage());
            }
        }
        return false;
    }

    private static boolean checkBonusSize(int bonus) {
        if (bonus < Constant.START_NUMBER.getConstant()|| Constant.END_NUMBER.getConstant() > 45) {
            throw new IllegalArgumentException(Error.BONUS_RANGE.getMessage());
        }
        return false;
    }
}
