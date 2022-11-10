package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public int getRanking(List<Integer> winns, int bonus) {
        int cnt = (int) numbers.stream().filter(winns::contains).count();
        int b = (int) numbers.stream().filter(i -> i==bonus).count();
        return cnt*10+b;
    }
}
