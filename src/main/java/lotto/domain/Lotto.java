package lotto.domain;

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
        return numbers;
    }

    public List<Integer> getPrized(List<Integer> luckyNumbers, int bonusNumbers) {
        Judgement judgement = new Judgement();
        return judgement.getRanking(numbers, luckyNumbers, bonusNumbers);
    }
}
