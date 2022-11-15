package lotto;

import java.util.List;

public class Utils {

    public static int convertStringToInt(String input) {
        int number;

        try {
            number = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INPUT_NOT_NUMBER));
        }
        return number;
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

    public static void validateNumbersRange(List<Integer> numbers) {

    }

}
