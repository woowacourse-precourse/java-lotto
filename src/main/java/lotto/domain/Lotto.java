package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final String WRONG_LOTTO_COUNT_ERROR_MESSAGE = "[ERROR] 로또의 번호는 6개이어야 합니다.";
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(WRONG_LOTTO_COUNT_ERROR_MESSAGE);
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getLotto() {
        return numbers;
    }

    public String getLottoNumbers() {
        return numbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lotto lotto = (Lotto) o;

        return Objects.equals(lotto, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
