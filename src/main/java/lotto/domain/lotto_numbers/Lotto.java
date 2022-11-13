package lotto.domain.lotto_numbers;

import static lotto.domain.constants.LottoConstants.COUNTS_OF_LOTTO_NUMBERS;
import static lotto.domain.constants.LottoConstants.MAX_NUMBER_OF_LOTTO;
import static lotto.domain.constants.LottoConstants.MIN_NUMBER_OF_LOTTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    static final String NOT_ALLOW_DUPLICATED_LOTTO_NUMBER = "중복 숫자는 입력될 수 없습니다.";
    static final String INVALID_SIZE_OF_LOTTO_NUMBERS = "로또 숫자는 6개만 입력할 수 있습니다.";
    static final String INVALID_RANGE_OF_LOTTO_NUMBER = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        validateRangeOfNumbers(numbers);
        this.numbers = sortedList(numbers);
    }

    private List<Integer> sortedList(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public int matchCounts(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    boolean contains(int number) {
        return numbers.contains(number);
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
                        number < MIN_NUMBER_OF_LOTTO || MAX_NUMBER_OF_LOTTO < number);

        if (presentInvalidNumber) {
            throw new IllegalArgumentException(INVALID_RANGE_OF_LOTTO_NUMBER);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
