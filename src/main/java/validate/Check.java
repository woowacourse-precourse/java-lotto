package validate;

import util.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Check {

    public static int countLottoTicket(Long paperMoney) {
        int tickets = (int) (paperMoney / 1000);

        if (paperMoney % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INSERT_COIN.getMessage());
        }

        return tickets;
    }

    public static void numberDuplicate(List<String> numbers) {

        Set<String> checkDuplicate = new HashSet<>(numbers);

        if (checkDuplicate.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    public static void numberDuplicate(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    public static void winningNumberCount(List<String> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_COUNT_ERROR.getMessage());
        }
    }

    public static void bonusNumberCount(List<String> numbers) {
        if (numbers.size() != 1) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_COUNT_ERROR.getMessage());
        }
    }

    public static void isNumber(String numbers) {
        if (!numbers.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ErrorMessage.NUMERIC_ERROR.getMessage());
        }
    }

    public static void isNumber(List<String> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (!numbers.get(i).chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException(ErrorMessage.NUMERIC_ERROR.getMessage());
            }

        }
    }

    public static void rightRange(List<String> numbers, int startNumber, int finishNumber) {
        for (int i = 0; i < numbers.size(); i++) {
            if (Integer.parseInt(numbers.get(i)) < startNumber || Integer.parseInt(numbers.get(i)) > finishNumber) {
                throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR.getMessage());
            }
        }
    }
}
