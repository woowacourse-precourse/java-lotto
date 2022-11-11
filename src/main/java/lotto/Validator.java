package lotto;

import static lotto.utils.ConstantUtil.LOTTO_NUMBER_SIZE;
import static lotto.utils.ConstantUtil.MAX_LOTTO_NUMBER;
import static lotto.utils.ConstantUtil.MIN_LOTTO_NUMBER;

import java.util.List;
import java.util.stream.Collectors;

public class Validator {
    private static final String SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호의 개수는 6개이어야 합니다.";
    private static final String DUPLICATES_ERROR_MESSAGE = "[ERROR] 로또 번호에 중복된 숫자가 있습니다.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호에 1 ~ 45 범위를 벗어난 숫자가 있습니다.";
    private static final String DIGIT_ERROR_MESSAGE = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String DIGIT_COMMA_ERROR_MESSAGE = "[ERROR] 숫자와 콤마(,)만 입력 가능합니다.";

    public void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    public void validateDuplicateNumber(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        if (numbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATES_ERROR_MESSAGE);
        }
    }

    public void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (isNotValidRange(number)) {
                throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
            }
        }
    }

    public void validateDigit(String input) {
        String replacedResult = input.replaceAll("[0-9,]", "");

        if (replacedResult.length() != 0) {
            throw new IllegalArgumentException(DIGIT_ERROR_MESSAGE);
        }
    }

    public void validateDigitAndComma(String input) {
        String replacedResult = input.replaceAll("[0-9,]", "");

        if (replacedResult.length() != 0) {
            throw new IllegalArgumentException(DIGIT_COMMA_ERROR_MESSAGE);
        }
    }

    private boolean isNotValidRange(int number) {
        return (!(MIN_LOTTO_NUMBER <= number && number <= MAX_LOTTO_NUMBER));
    }
}
