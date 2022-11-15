package lotto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator validator = new Validator();
        validator.validateLotto(numbers);
    }

    // TODO: 추가 기능 구현
    public String toString(){
        return numbers.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()).toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
