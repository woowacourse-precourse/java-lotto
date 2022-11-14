package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> list = new ArrayList<>(numbers);
        Collections.sort(list);
        this.numbers = list;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> set = new HashSet(numbers);

        if (set.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        
        return numbers;
    }
}
