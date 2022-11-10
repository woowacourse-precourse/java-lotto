package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private ValidationInDomain validator = new ValidationInDomain();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validator.checkDuplicatedNumber(numbers);
        this.numbers = numbers;
        sortInAscendingOrder();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers(){
        return numbers;
    }

    private void sortInAscendingOrder(){
        Collections.sort(numbers);
    }
}
