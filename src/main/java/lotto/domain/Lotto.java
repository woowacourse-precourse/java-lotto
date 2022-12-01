package lotto.domain;

import lotto.validate.LottoValidate;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        new LottoValidate().validate(numbers);
    }

    public boolean contains(int bonus) {
        if (numbers.contains(bonus)) {
            return true;
        }
        return false;
    }

    public int matchCount(Lotto other) {
        int count = 0;
        for (int index = 0; index < numbers.size(); index++) {
            if (other.contains(numbers.get(index))) count++;
        }
        return count;
    }

    @Override
    public String toString() {
        return numbers.stream().map(String::valueOf).collect(Collectors.joining(", ","[","]"));
    }
}
