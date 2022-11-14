package lotto.domain;

import lotto.exception.LottoInputException;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private static final int MAX = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        checkNumber(numbers);
        this.numbers = numbers;
    }

    private void checkNumber(List<LottoNumber> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != MAX) {
            throw new LottoInputException("[ERROR]");
        }
    }

    private void checkDuplicate(List<LottoNumber> numbers) {
        if (numbers.stream().distinct().count() != MAX) {
            throw new LottoInputException("[ERROR] 중복된 숫자를 입력했습니다.");
        }
    }

    public boolean bonus(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public int countMatchNumber(Lotto comPareLotto) {
        return Math.toIntExact(numbers.stream().filter(comPareLotto::matchCountLottoNumber).count());

    }

    private boolean matchCountLottoNumber(LottoNumber compareNumber) {
        return numbers.stream().anyMatch(controlNumber -> controlNumber.equals(compareNumber));
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

    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
