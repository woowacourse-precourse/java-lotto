package lotto.validator;

import lotto.domain.LottoCondition;
import lotto.message.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {
    private static final String INPUT_DELIMITER = ",";

    public static void validatePayment(int payment, int eachPrice) {
        if (payment % eachPrice != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_PRICE.getMessage());
        }
    }

    public static void validateZero(int payment) {
        if (payment == 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_INTEGER.getMessage());
        }
    }

    public static int changeInputToInt(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIGIT.getMessage());
        }

        return Integer.parseInt(input);
    }

    public static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LottoCondition.COUNT.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    public static void validateNumberRange(int number) {
        if (number < LottoCondition.MIN_NUMBER.getNumber() || number > LottoCondition.MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    public static void validateOverlappingNumbers(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();
        if (numbers.size() != distinctCount) {
            throw new IllegalArgumentException(ErrorMessage.OVERLAPPED_NUMBER.getMessage());
        }
    }

    public static void validateOverlappingBonusNumbers(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.OVERLAPPED_NUMBER.getMessage());
        }
    }

    public static List<Integer> changeInputToIntegerList(String input) {
        List<String> splitElements = Arrays.asList(input.split(INPUT_DELIMITER));
        List<Integer> numbers = splitElements.stream()
                .map(InputValidator::changeInputToInt)
                .collect(Collectors.toList());

        return numbers;
    }

    private static boolean isNumeric(String input) {
        return input.chars().allMatch(Character::isDigit);
    }
}
