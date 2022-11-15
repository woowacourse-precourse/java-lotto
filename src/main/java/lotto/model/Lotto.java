package lotto.model;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(int num) {
        return this.numbers.contains(num);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
