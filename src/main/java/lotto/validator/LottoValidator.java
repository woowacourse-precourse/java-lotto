package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator extends NumberValidator {
    private final static String DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복된 숫자는 입력할 수 없습니다.";

    public static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        if (numSet.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateLottoNumberRange(number);
        }
    }

    public static void validateNonNumericNumbers(List<String> numbers) {
        for (String number : numbers) {
            validateNonNumeric(number);
        }
    }
}