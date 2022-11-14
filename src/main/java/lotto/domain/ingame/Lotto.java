package lotto.domain.ingame;

import lotto.exception.BallValueDuplicateException;
import lotto.view.OutputView;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        try {
            validate(numbers);
        } catch (Exception exception) {
            OutputView.showError(exception);
            throw new IllegalArgumentException();
        }
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (numbers.size()!= numbers.stream().distinct().count()) {
            throw new BallValueDuplicateException();
        }
    }

    public int compare(List<Integer> luckyNumbers) {
        return (int) numbers.stream()
                .filter(luckyNumbers::contains)
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
