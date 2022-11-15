package lotto;

import java.util.List;

public class Utils {

    private static final int LOTTO_SIZE = 6;

    public static void validateInput(char c) {
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INPUT_NOT_NUMBER));
        }
    }

    public static int convertStringToInt(String input) {
        for (int i = 0; i < input.length(); i++) {
            validateInput(input.charAt(i));
        }
        return Integer.parseInt(input);
    }


    public static void validateDuplicatedNum(List<Integer> numbers, int numIdx) {
        if (numbers.indexOf(numbers.get(numIdx)) != numIdx) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.NOT_UNIQUE_NUMBERS));
        }
    }

    public static void validateUniqueNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            validateDuplicatedNum(numbers, i);
        }
    }

    public static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.OUT_OF_RANGE));
        }
    }

    public static void validateNumbersRange(List<Integer> numbers) {
        for (int num : numbers) {
            validateNumberRange(num);
        }
    }

    public static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INVALID_SIZE));
        }
    }

}
