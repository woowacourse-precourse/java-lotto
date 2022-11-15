package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.common.Error;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        require(numbers.size() != 6, Error.SIZE);
        Set<Integer> set = new HashSet<>(numbers);
        require(set.size() != 6, Error.SIZE);
    }

    private void require(final boolean condition, final Error error) {
        if (condition) {
            throw new IllegalArgumentException(error.getMsg());
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
