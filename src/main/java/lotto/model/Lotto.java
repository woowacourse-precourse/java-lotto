package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        Set<Integer> duplicationCheck = new HashSet<>(numbers);
        if (duplicationCheck.size() != 6){
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
