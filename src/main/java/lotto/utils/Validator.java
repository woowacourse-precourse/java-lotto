package lotto.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static final int TICKET_PRICE = 1000;
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
        validateDuplicate(numbers);
        validateArraySize(numbers, WINNING_NUMS);
    }

    public static void validateArraySize(List<String> numbers, int size){
        if (numbers.size() != size){
            throw new IllegalArgumentException("숫자의 개수가 잘못 되었습니다.");
        }
    }

    public static void validateDuplicate(List<String> numbers){
        Set<String> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != WINNING_NUMS){
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    public static void validateBudget(int budget){
        if (budget % TICKET_PRICE != 0){
            throw new IllegalArgumentException("구입 금액을 1000원으로 나누어 떨어지게 입력해주세요.");
        }
    }
}
