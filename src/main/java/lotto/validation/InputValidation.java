package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.ExceptionConstant.*;
import static lotto.constant.LottoConstant.PRICE;

public class InputValidation {

    public static boolean isNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException(NUMBER_INPUT_ERROR.getMessage());
        }
        return true;
    }

    public static boolean isValidUnit(int userInput) {
        if (userInput % PRICE.getValue() == 0) {
            return true;
        }
        throw new IllegalArgumentException(PRICE_ERROR.getMessage());
    }

    public static void isValidLottoWinInput(List<String> userInput) {
        isCorrectCount(userInput);
        isAllNumber(userInput);
        isDuplication(userInput);
    }

    public static void isCorrectCount(List<String> userInput) {
        if (userInput.size() != 6) {
            throw new IllegalArgumentException(INVALID_FORMAT_ERROR.getMessage());
        }
    }

    public static void isAllNumber(List<String> userInput) {
        for (String number: userInput) {
            isNumber(number);
        }
    }

    public static void isDuplication(List<String> userInput) {
        Set<String> notDuplicationNumber = new HashSet<>();
        for(String input: userInput) {
            notDuplicationNumber.add(input);
        }
        if (notDuplicationNumber.size() != 6) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR.getMessage());
        }
    }
}
