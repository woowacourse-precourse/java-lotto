package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String LOTTO_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String LOTTO_HAS_DUPLICATED_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateLottoRange(numbers);
        validateDuplicateCount(numbers);

        ArrayList<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    public int calculateSameCount(Lotto lotto) {
        return (int) lotto.numbers.stream()
                .filter(this::checkContains)
                .count();
    }

    public boolean checkContains(int otherLottoNumber) {
        return numbers.contains(otherLottoNumber);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLottoRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(LOTTO_RANGE_ERROR_MESSAGE);
            }
        }
    }

    private void validateDuplicateCount(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(LOTTO_HAS_DUPLICATED_NUMBER_ERROR_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
