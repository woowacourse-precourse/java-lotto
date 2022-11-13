package lotto.domain;

import java.util.Iterator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] Lotto의 당첨 번호는 6개입니다.");
        }
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

    public Iterator<Integer> createIterator() {
        return this.numbers.iterator();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
