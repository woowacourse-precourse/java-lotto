package lotto.model;

import lotto.util.Validate;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        Validate.length(numbers, 6);
        Validate.range(numbers, 1, 45);
        Validate.duplication(numbers);
    }

    public Rank result(List<Integer> input, int bonusNumber) {
        int count = (int) input.stream().filter(e -> numbers.contains(e)).count();

        if (count != 5) {
            return Rank.findByRank(new Result(count, false));
        }

        return Rank.findByRank(new Result(count, numbers.contains(bonusNumber)));
    }
}
