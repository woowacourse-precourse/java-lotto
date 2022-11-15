package lotto.controller;

import static lotto.controller.Constants.*;

import java.util.List;

public class ExceptionHandler {
    private static final String pattern = "^[0-9]*$";

    public static void validateMoneyUnit(int money) {

        if (money % MONEY_UNIT != 0 || pattern.matches(Integer.toString(money))) {
            throw new IllegalArgumentException(INPUT_CORRECT_FORMAT_MONEY);
        }
    }

    public static void validateWinNumber(List<Integer> winNumbers) {
        String pattern = "^[0-9]*$";
        for(int winNumberElement : winNumbers) {
            if(pattern.matches(Integer.toString(winNumberElement))) {
                throw new IllegalArgumentException(NUMBER_RANGE_MUST_BETWEEN_1_45);
            }
        }
        if(winNumbers.stream().distinct().count() != winNumbers.size()){
            throw new IllegalArgumentException(DUPLICATED_NUMBER_IS_NOT_ALLOWED);
        }
    }

    public static void validateBonusNumber(int bonusNumber) {
        if (pattern.matches(Integer.toString(bonusNumber))) {
            throw new IllegalArgumentException(NUMBER_RANGE_MUST_BETWEEN_1_45);
        }
    }
}
