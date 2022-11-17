package lotto;

import java.util.List;

public class Validation {
    
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final int NUMBERS_SIZE = 6;
    private static final long ZERO = 0L;
    private static final long MIN_UNIT = 1000L;

    private Validation(){}

    public static void validateNumber(String str) {
        String regex = "[0-9]+";
        if (!str.matches(regex)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER.printError());
        }
    }
    
    public static void validateRange(String str) {
        int num = Integer.parseInt(str);
        if (num > MAX_NUMBER || num < MIN_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_RANGE.printError());
        }
    }
    
    public static void validateUnit(String str) {
        long num = Long.parseLong(str);
        if (num % MIN_UNIT != ZERO || num == ZERO) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_PROPER_UNIT.printError());
        }
    }

    public static void validateMoney(String str) {
        validateNumber(str);
        validateUnit(str);
    }

    public static void validateNumbers(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersRange(numbers);
        validateNumbersDuplicate(numbers);
    }

    private static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_SIX.printError());
        }
    }

    private static void validateNumbersRange(List<Integer> numbers) {
        long count = numbers.stream().filter(s -> s >= 1 && s <= 45)
                .count();
        if (count != NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_RANGE.printError());
        }
    }

    private static void validateNumbersDuplicate(List<Integer> numbers) {
        long count = numbers.stream().distinct().count();
        if (count != NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DUPLICATE.printError());
        }
    }
}
