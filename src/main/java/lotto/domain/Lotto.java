package lotto.domain;

import lotto.utils.validator.LottoValidator;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public static void validate(List<Integer> numbers) {
        LottoValidator.checkSixNumbers(numbers);
        LottoValidator.checkLottoNumbers(numbers);
        LottoValidator.checkDuplicateNumber(numbers);
    }

    public void sortNumbers() {
        numbers.sort(Integer::compareTo);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}