package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자가 아닙니다.");
        }

        HashSet<Integer> set = new HashSet<>(numbers);

        if(set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 들어갔습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
