package lotto.validation;

import lotto.model.ErrorMessage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Validation {

    public static Integer userInputMoneyCheck(String userInput) {
        try {
            isNumber(userInput);
            isMoneyMatch(Integer.parseInt(userInput));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return 0;
        }
        return Integer.parseInt(userInput);
    }

    private static void isNumber(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE.getErrorMessage() + ErrorMessage.ERROR_PURCHASED_DATAFORMAT);
        }
    }

    private static void isNumberInBoundary(int min, int max, int input) {
        if (input < min) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE.getErrorMessage() + ErrorMessage.ERROR_BONUS_RANGE);
        }
        if (input > max) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE.getErrorMessage() + ErrorMessage.ERROR_BONUS_RANGE);
        }
    }

    private static void isMoneyMatch(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE.getErrorMessage() + ErrorMessage.ERROR_PURCHASED_RANGE);
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE.getErrorMessage() + ErrorMessage.ERROR_PURCHASED_UNIT);
        }
    }

    public static int bonusNumberCheck(List<Integer> winNumber, String userInput) {

        try {
            isNumber(userInput);
            int bonus = Integer.parseInt(userInput);
            isDuplicateBonusNumber(winNumber,bonus);
            isNumberInBoundary(1,45, bonus);

        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return 0;
        }
        return Integer.parseInt(userInput);
    }

    private static void isDuplicateBonusNumber(List<Integer> winNumber, int bonus) {
        if (winNumber.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PURCHASED_UNIT.getErrorMessage() + ErrorMessage.ERROR_BONUS_DUPLICATION);
        }
    }

    public static List<Integer> winNumberCheck(String userInput) {

        String[] numbers = userInput.split(",");

        try {
            validateWinNumberInput(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return Collections.emptyList();
        }
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static void validateWinNumberInput(String input) {
        String[] split = input.split(",");

        if (split.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요");
        }

        for (String str : split) {
            isNumber(str);
        }

        for (String s : split) {
            int num = Integer.parseInt(s);
            isNumberInBoundary(1, 45, num);
        }
    }

}
