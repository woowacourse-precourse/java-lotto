package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        checkDuplication();
        sort();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자가 아닙니다.");
        }
    }

    public void sort() {
        Collections.sort(numbers);
    }

    public void checkDuplication() {
        Set<Integer> removedDuplication = new HashSet<Integer>(numbers);

        if (removedDuplication.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 수를 입력할 수 없습니다.");
        }
    }

    public String toString() {
        String sentence= "[";

        for (int i = 0; i < numbers.size() - 1; i++) {
            sentence += numbers.get(i) + ", ";
        }

        sentence += numbers.get(5);
        sentence += "]";

        return sentence;
    }
}
