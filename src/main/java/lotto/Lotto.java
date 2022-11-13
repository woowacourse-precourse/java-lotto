package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> asSortedList(){
        List<Integer> sorted = this.numbers;
        Collections.sort(sorted);
        return sorted;
    }

    // TODO: 추가 기능 구현
}