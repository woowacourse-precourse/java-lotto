package lotto.Lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final Integer LOTTO_NUMBER_LENGTH = 6;
    private static final Integer MINIMUM_RANGE_OF_LOTTO_NUMBER = 1;
    private static final Integer MAXIMUM_RANGE_OF_LOTTO_NUMBER = 45;

    private static final String NOT_NUMERIC_WARNING_MESSAGE = "[ERROR] 로또 번호는 숫자여야 합니다.";
    private static final String LOTTO_NUMBER_WRONG_LENGTH_WARNING_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String LOTTO_NUMBER_OUT_OF_RANGE_WARNING_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String DUPLICATED_LOTTO_NUMBER_WARNING_MESSAGE = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";

    private final List<Integer> numbers;

    public Lotto(String numbers) {
        List<Integer> newNumbers = castNumbers(numbers);
        validateLottoNumber(newNumbers);
        this.numbers = newNumbers;
    }

    private List<Integer> castNumbers(String numbers) {
        List<Integer> newNumbers = new ArrayList<>();
        String[] partedNumbers = numbers.split(",");

        for (String number : partedNumbers) {
            validateNumeric(number);
            newNumbers.add(Integer.valueOf(number));
        }

        return newNumbers;
    }

    private void validateNumeric(String number) {
        try {
            Double.parseDouble(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_WARNING_MESSAGE);
        }
    }

    private void validateLottoNumber(List<Integer> numbers) {
        validateLottoNumberLength(numbers);
        validateLottoNumberRange(numbers);
        validateDuplicatedNumber(numbers);
    }

    private void validateLottoNumberLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(LOTTO_NUMBER_WRONG_LENGTH_WARNING_MESSAGE);
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MINIMUM_RANGE_OF_LOTTO_NUMBER || number > MAXIMUM_RANGE_OF_LOTTO_NUMBER) {
                throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE_WARNING_MESSAGE);
            }
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> validNumbers = new HashSet<>(numbers);

        if (validNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER_WARNING_MESSAGE);
        }
    }


}
