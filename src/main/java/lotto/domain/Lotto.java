package lotto.domain;

import java.util.List;

enum Rank {
    ONE(2000000000), TWO(30000000), THREE(1500000), FOUR(50000), FIVE(5000);
    private int money;
    Rank(int money) {
        this.money = money;
    }
}

public class Lotto {
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

    // TODO: 추가 기능 구현
    static List<Integer> compare(List<Integer> numbers) {
        return null;
    }
}
