package lotto.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] Lotto의 당첨 번호는 6개입니다.");
        }
    }

    // TODO: 추가 기능 구현
    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

    public Iterator<Integer> createIterator() {
        return this.numbers.iterator();
    }

    @Override
    public String toString() {
        Collections.sort(numbers);
        return numbers.toString();
    }
}
