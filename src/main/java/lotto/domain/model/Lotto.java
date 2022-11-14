package lotto.domain.model;

import lotto.domain.io.DuplicationValidator;
import lotto.domain.io.NumberLengthValidator;
import lotto.domain.io.RangeValidator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> lotto = new ArrayList<>(numbers);
        validate(lotto);
        this.numbers = lotto;
    }

    private void validate(List<Integer> numbers) {
        NumberLengthValidator numberLengthValidator = new NumberLengthValidator();
        RangeValidator rangeValidator = new RangeValidator();
        DuplicationValidator duplicationValidator = new DuplicationValidator();

        numberLengthValidator.validate(numbers);
        rangeValidator.validate(numbers);
        duplicationValidator.validate(numbers);
        sort(numbers);
    }

    public void sort(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
