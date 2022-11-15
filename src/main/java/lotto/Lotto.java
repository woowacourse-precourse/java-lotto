package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers = new ArrayList<>();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers.addAll(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않은 수들로 이루어져야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    
}
