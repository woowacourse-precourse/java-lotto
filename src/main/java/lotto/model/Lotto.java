package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    int prize;
    int prizeMoney;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    void addPrize(int prize) {
        this.prize = prize;
    }

    void addPrizeMoney(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    List<Integer> getNumbers() {
        return numbers;
    }

    int getPrize() {
        return prize;
    }

    int getPrizeMoney() {
        return prizeMoney;
    }
}
