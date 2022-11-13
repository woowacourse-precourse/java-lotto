package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class Validator {
    public static final int WINNING_NUMS = 6;
    public static void validateInteger(String input){
        if (! input.matches("[0-9]+")) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    public static void validateWinningNumbers(List<String> numbers){
        for (String number : numbers){
            validateInteger(number);
        }

        validateArraySize(numbers, WINNING_NUMS);
    }

    public static void validateArraySize(List<String> numbers, int size){
        if (numbers.size() != size){
            throw new IllegalArgumentException("숫자의 개수가 잘못 되었습니다.");
        }
    }
}
