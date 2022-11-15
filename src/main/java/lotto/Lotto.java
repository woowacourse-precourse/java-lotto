package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = sortNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);

        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        if (set.size() < numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복된 수로 구성될 수 없습니다.");
        }
    }

    private List<Integer> sortNumber(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
