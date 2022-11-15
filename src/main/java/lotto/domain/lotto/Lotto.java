package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String NOT_SIX_NUMBERS_ERROR = "[ERROR] 로또 번호는 6개의 수로만 이루어져야 합니다.";
    private static final String HAS_DUPLICATED_NUMBERS_ERROR = "[ERROR] 로또 번호에는 중복이 없어야 합니다.";
    private static final String LOTTO_NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 1~45까지의 정수여야 합니다.";

    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        validateSixDigits(numbers);
        validateDuplicatedNumber(numbers);
        validateNumberRange(numbers);

        List<Integer> tempNumbers = new ArrayList<>(numbers);
        Collections.sort(tempNumbers);

        this.numbers = tempNumbers;
    }

    private void validateSixDigits(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NOT_SIX_NUMBERS_ERROR);
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> tempSet = new HashSet<>(numbers);

        if (tempSet.size() != 6) {
            throw new IllegalArgumentException(HAS_DUPLICATED_NUMBERS_ERROR);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR);
            }
        }
    }
}
