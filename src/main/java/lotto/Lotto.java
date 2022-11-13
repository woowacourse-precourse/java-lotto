package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        checkOverlap(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void checkOverlap(List<Integer> numbers){
        Set<Integer> checkNumbers = new HashSet<Integer>(numbers);
        if(checkNumbers.size() != numbers.size()) throw new IllegalArgumentException("[ERROR]");
    }

    // TODO: 추가 기능 구현
}
