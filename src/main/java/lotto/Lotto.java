package lotto;

import java.util.Collections;
import java.util.List;

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

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int getRanking(List<Integer> wins, int bonus) {
        int cnt = getCount(wins);
        int b = getBonus(bonus);
        return getRank(cnt, b);
    }

    private int getCount(List<Integer> wins) {
        return (int) numbers.stream().filter(wins::contains).count();
    }

    private int getBonus(int bonus) {
        return  (int) numbers.stream().filter(i -> i== bonus).count();
    }

    private int getRank(int cnt, int b) {
        return cnt * 10 + b;
    }
}
