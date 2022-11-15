package lotto.validator;

import lotto.model.enums.ErrorMessage;
import lotto.model.enums.GameMessage;

import java.util.List;

public class Validator {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static void validateDigit(String userInput) {
        for (int index = 0; index < userInput.length(); index++) {
            if (!Character.isDigit(userInput.charAt(index))) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
            }
        }
    }

    public static void validateBonusRange(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateElement(String inputLuckySix) {
        String testElement = inputLuckySix.replaceAll(",", "");
        if (!Character.isDigit(Integer.parseInt(testElement))) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateSixNumber(String inputLuckySix) {
        for (int index = 0; index < inputLuckySix.length(); index++) {
            char oneNumber = inputLuckySix.charAt(index);
            if (oneNumber == ',') {
                continue;
            }
            if (!Character.isDigit(oneNumber)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validatePrice(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }
}
