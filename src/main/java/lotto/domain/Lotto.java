package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;
    private static final String LOTTO_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String LOTTO_HAS_DUPLICATED_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private static final String LOTTO_SIZE_ERROR = "[ERROR] 중복되지 않는 숫자 6개를 입력해 주세요.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public int calculateSameCount(Lotto lotto) {
        return (int) lotto.numbers.stream()
                .filter(this::checkContains)
                .count();
    }

    protected boolean checkContains(int otherLottoNumber) {
        return numbers.contains(otherLottoNumber);
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        for (Integer number : numbers) {
            validateLottoRange(number);
            validateDuplicateCount(number, numbers);
        }
    }

    private static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR);
        }
    }

    protected void validateLottoRange(Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(LOTTO_RANGE_ERROR_MESSAGE);
        }
    }

    private void validateDuplicateCount(Integer number, List<Integer> numbers) {
        if (numbers.indexOf(number) != numbers.lastIndexOf(number)) {
            throw new IllegalArgumentException(LOTTO_HAS_DUPLICATED_NUMBER_ERROR_MESSAGE);
        }
    }
    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
