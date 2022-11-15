package lotto.domain;

import static lotto.util.Constant.*;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateConsistOfNumBetween1And45(numbers);
        validateOverlap(numbers);
        ascendingLotto(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    // 서로 다른 숫자로 구성되었는지 검증하는 기능
    private void validateOverlap(List<Integer> numbers) {
        Set<Integer> lotto = new HashSet<>(numbers);
        if (numbers.size() != lotto.size()) {
            throw new IllegalArgumentException(ERROR_MSG_SAME_NUMBER);
        }
    }

    // 로또 숫자가 1부터 45사이의 수로 구성되어 있는지 검증하는 기능
    private void validateConsistOfNumBetween1And45(List<Integer> numbers) {
        List<Integer> lotto = numbers.stream()
            .filter(num -> LOTTO_MIN_NUM <= num && num <= LOTTO_MAX_NUM)
            .collect(Collectors.toList());
        if (lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_MSG_OTHER_NUMBER_BETWEEN_1_AND_45);
        }
    }

    // 로또 번호를 오름차순으로 정령하는 기능
    private void ascendingLotto(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }

    // 로또 번호를 가져오는 기능
    public List<Integer> getNumbers() {
        return numbers;
    }
}
