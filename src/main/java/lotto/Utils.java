package lotto;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    private static final int LOTTO_SIZE = 6;

    public static int convertStringToInt(String input) {
        try {
            int result = Integer.parseInt(input);
            return result;
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorCode.INPUT_NOT_NUMBER.getMessage());
        }
    }


    public static void validateDuplicatedNum(List<Integer> numbers, int numIdx) {
        if (numbers.indexOf(numbers.get(numIdx)) != numIdx) {
            throw new IllegalArgumentException(ErrorCode.NOT_UNIQUE_NUMBERS.getMessage());
        }
    }

    public static void validateUniqueNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            validateDuplicatedNum(numbers, i);
        }
    }

    public static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorCode.OUT_OF_RANGE.getMessage());
        }
    }

    public static void validateNumbersRange(List<Integer> numbers) {
        for (int num : numbers) {
            validateNumberRange(num);
        }
    }

    public static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorCode.INVALID_SIZE.getMessage());
        }
    }

    public static List<Integer> convertStringToIntList(String strs) {
        List<Integer> result = new ArrayList<>();

        for (String str : strs.split(",")) {
            result.add(convertStringToInt(str));
        }
        return result;
    }

}
