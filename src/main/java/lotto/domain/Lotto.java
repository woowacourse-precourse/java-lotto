package lotto.domain;

import lotto.support.Validator;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private static final Validator validator=Validator.getInstance();
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

    }

    // TODO: 추가 기능 구현
    public Lotto sort(){
        numbers.sort(Comparator.naturalOrder());
        return this;
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
