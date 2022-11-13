package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto { // Lotto-create-001
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object obj) {
        Lotto lotto = (Lotto) obj;
        return new HashSet<>(this.numbers).containsAll(lotto.numbers);
    }

    public List<Integer> getNumbers(){ // Lotto-print-001
        return this.numbers;
    }
    // TODO: 추가 기능 구현
}
