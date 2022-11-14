package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_LENGTH = 6;

    private final Set<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new HashSet<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public Set<Integer> getLotto() {
        return numbers;
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
