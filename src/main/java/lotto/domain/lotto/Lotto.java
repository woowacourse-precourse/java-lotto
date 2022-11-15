package lotto.domain.lotto;

import lotto.exception.lotto.LottoNumDuplicatedException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {
    private static final int SIZE = 6;
    final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = List.copyOf(numbers);
    }

    private static void validate(List<LottoNumber> numbers) {
        Set<LottoNumber> setNumbers = new HashSet<>(numbers);

        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException();
        }

        if (setNumbers.size() != numbers.size()){
            throw new LottoNumDuplicatedException(numbers);
        }
    }

    // TODO: 추가 기능 구현
    public static Lotto from(final List<LottoNumber> numbers){
        return new Lotto(numbers);
    }

    public int countSameNum(final WinningLotto winningLotto){
        return (int) numbers.stream()
                .filter(winningLotto::contains)
                .count();
    }
    public boolean contains(final LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }
    public List<LottoNumber> get() {
        return List.copyOf(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(numbers, lotto1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lotto=" + numbers +
                '}';
    }
}
