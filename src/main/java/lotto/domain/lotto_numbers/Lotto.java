package lotto.domain.lotto_numbers;

import static lotto.domain.lotto_numbers.LottoNumbersErrorMessages.INVALID_RANGE_OF_LOTTO_NUMBER;
import static lotto.domain.lotto_numbers.LottoNumbersErrorMessages.INVALID_SIZE_OF_LOTTO_NUMBERS;
import static lotto.domain.lotto_numbers.LottoNumbersErrorMessages.NOT_ALLOW_DUPLICATED_LOTTO_NUMBER;
import static lotto.domain.policy.LottoPolicy.COUNTS_OF_LOTTO_NUMBERS;
import static lotto.domain.policy.LottoPolicy.MAX_NUMBER_OF_LOTTO;
import static lotto.domain.policy.LottoPolicy.MIN_NUMBER_OF_LOTTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        validateRangeOfNumbers(numbers);
        this.numbers = numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int matchNumberCounts(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public List<Integer> numbers() {
        List<Integer> copied = new ArrayList<>(numbers);
        Collections.sort(copied);
        return Collections.unmodifiableList(copied);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != COUNTS_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException(INVALID_SIZE_OF_LOTTO_NUMBERS);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> setOfNumbers = new HashSet<>(numbers);
        if (setOfNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(NOT_ALLOW_DUPLICATED_LOTTO_NUMBER);
        }
    }

    private void validateRangeOfNumbers(List<Integer> numbers) {
        boolean presentInvalidNumber = numbers.stream()
                .anyMatch(number ->
                        number < MIN_NUMBER_OF_LOTTO || MAX_NUMBER_OF_LOTTO < number
                );

        if (presentInvalidNumber) {
            throw new IllegalArgumentException(INVALID_RANGE_OF_LOTTO_NUMBER);
        }
    }
}
