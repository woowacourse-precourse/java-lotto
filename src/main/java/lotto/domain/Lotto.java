package lotto.domain;

import lotto.LottoInputException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private static final int MAX = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        checkNumber(numbers);
        this.numbers = convertLottoNumber(numbers);
    }

    private void checkNumber(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
    }

    private List<LottoNumber> convertLottoNumber(List<Integer> numbers) {
        return numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != MAX) {
            throw new LottoInputException("[ERROR]");
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력했습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
