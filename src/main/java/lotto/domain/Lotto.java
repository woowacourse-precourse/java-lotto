package lotto.domain;

import lotto.ui.Validator;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || !Validator.isInRange(numbers) || Validator.isDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public Result computeResult(Set<Integer> winningNumbers, int bonusNumber) {
        int score = (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();

        score *= 10;
        if (score == 50 && numbers.contains(bonusNumber)) {
            score++;
        }

        return Result.getResult(score);
    }
}
