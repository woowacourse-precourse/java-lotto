package lotto.domain;

import lotto.util.Validator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Validator.LOTTO_SIZE || !Validator.isInRange(numbers) || Validator.isDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public Result computeResult(Set<Integer> winningNumbers, int bonusNumber) {
        int score = (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count() * 10;

        if (score == Result.FIVE.getScore() && numbers.contains(bonusNumber)) {
            score++;
        }

        return Result.computeScore(score);
    }

    public String makeString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
