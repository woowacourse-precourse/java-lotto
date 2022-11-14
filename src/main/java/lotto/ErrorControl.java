package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ErrorControl {

    public static void validateSeparatorAndSize(String[] input) {
        if (input.length != Constants.LOTTO_SIZE) {
            throw new MyIllegalArgumentException(Constants.ERROR_MESSAGE_INPUT_SIX_NUMBER_WITH_SEPARATOR);
        }
    }

    public static void validateNumberInRange(String number) {
        int convertNumber;
        try {
            convertNumber = Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            throw new MyIllegalArgumentException(Constants.ERROR_MESSAGE_INPUT_NUMBER);
        }
        if (convertNumber < Constants.MIN_LOTTO_NUMBER | convertNumber > Constants.MAX_LOTTO_NUMBER) {
            throw new MyIllegalArgumentException(Constants.ERROR_MESSAGE_INPUT_NUMBER_IN_RANGE);
        }
    }

    public static int validateDuplicateNumber(List<Integer> winNumbers, int number) {
        if (winNumbers.contains(number)) {
            throw new MyIllegalArgumentException(Constants.ERROR_MESSAGE_NO_DUPLICATE_IN_WIN_NUMBER);
        }
        return number;
    }

    public static void validateNumber(String money) {
        try {
            Double.parseDouble(money);
        } catch (IllegalArgumentException e) {
            throw new MyIllegalArgumentException(Constants.ERROR_MESSAGE_INPUT_NUMBER);
        }
    }

    public static double validateDivideThousand(double money) {
        if (money % Constants.LOTTO_PRICE != 0) {
            throw new MyIllegalArgumentException(Constants.ERROR_MESSAGE_INPUT_THOUSANDS_NUMBER);
        }
        return money;
    }

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_SIZE) {
            throw new MyIllegalArgumentException(Constants.ERROR_MESSAGE_NOT_LOTTO_SIZE);
        }
    }

    public static void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> numbersToCheck = new HashSet<>(numbers);
        if (numbers.size() != numbersToCheck.size()) {
            throw new MyIllegalArgumentException(Constants.ERROR_MESSAGE_NO_DUPLICATE_IN_LOTTO_NUMBER);
        }
    }

    public static void validateNumberOfSeparate(String input) {
        int numberOfSeparate = 0;
        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(index) == ',') {
                numberOfSeparate++;
            }
        }
        if (numberOfSeparate != Constants.LOTTO_SIZE-1){
            throw new MyIllegalArgumentException(Constants.ERROR_MESSAGE_USE_CORRECT_SEPARATOR_NUMBER);
        }
    }

}