package domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        isDifferentEachOther(numbers);
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void isDifferentEachOther(List<Integer> numbers) {
        Set<Integer> eachOtherLotto = new HashSet<>(numbers);
        if (eachOtherLotto.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }


}
