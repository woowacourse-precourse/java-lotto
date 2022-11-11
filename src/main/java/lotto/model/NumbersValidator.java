package lotto.model;

import java.util.List;

class NumbersValidator {
    public static final int NUMBER_REQUIRED_SIZE = 6;
    public static final int NUMBER_MIN_VALUE = 1;
    public static final int NUMBER_MAX_VALUE = 45;
    public static final String NUMBER_REPEAT_ERROR = "[ERROR] 중복된 숫자가 있습니다.";
    public static final String NUMBERS_SIZE_ERROR = "[ERROR] 숫자가 " + NUMBER_REQUIRED_SIZE + "개이여야 합니다.";
    public static final String NUMBER_RANGE_ERROR =
            "[ERROR] 모든 수가 범위(" + NUMBER_MIN_VALUE + "~" + NUMBER_MAX_VALUE + ")안에 있어야 합니다.";


    private NumbersValidator() {
    }

    static boolean isValid(List<Integer> numbers) {
        try {
            isValidSize(numbers);
            isValidRepeat(numbers);
            isValidRange(numbers);
            return true;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return false;
        }
    }

    public static void isValidSize(List<Integer> numbers) throws IllegalArgumentException {
        if ( numbers.size() != NUMBER_REQUIRED_SIZE) {
            throw new IllegalArgumentException(NUMBERS_SIZE_ERROR);
        }
    }

    public static void isValidRepeat(List<Integer> numbers) throws IllegalArgumentException {
        long numbersSize = numbers.stream().distinct().count();
        if (numbersSize != NUMBER_REQUIRED_SIZE) {
            throw new IllegalArgumentException(NUMBER_REPEAT_ERROR);
        }
    }

    public static void isValidRange(List<Integer> numbers) throws IllegalArgumentException {
        boolean anyMatch = numbers.stream()
                .anyMatch(number -> number < NUMBER_MIN_VALUE || number > NUMBER_MAX_VALUE);
        if (anyMatch) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR);
        }
    }
}
