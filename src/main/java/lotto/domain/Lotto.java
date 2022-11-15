package lotto.domain;

import lotto.utils.Constant;
import lotto.utils.ExceptionMessages;
import lotto.utils.LottoNumberRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
        validate();
        Collections.sort(this.numbers);
    }

    private void validate() {
        isCorrectLottoNumberCount();
        isUniqueLottoNumbers();
        isSatisfiedLottoNumberRange();
    }

    private void isCorrectLottoNumberCount() {
        if (numbers.size() != Constant.CORRECT_LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessages.LOTTO_ONLY_SIX_SIZE);
        }
    }

    private void isUniqueLottoNumbers() {
        if (numbers.stream()
                .distinct()
                .count() != Constant.CORRECT_LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessages.LOTTO_ONLY_UNIQUE_NUMBERS);
        }
    }

    private void isSatisfiedLottoNumberRange() {
        numbers.forEach(LottoNumberRange::validateLottoNumberRage);
    }

    public boolean isSortedLottoNumbers(ArrayList<Integer> compareNumbers) {
        Collections.sort(compareNumbers);
        for (int index = 0; index < Constant.CORRECT_LOTTO_SIZE; index++) {
            if (!compareNumbers.get(index).equals(this.numbers.get(index))) {
                return false;
            }
        }
        return true;
    }

    public Integer getIndexLottoNumber(int index) {
        return numbers.get(index);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
