package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Prize toPrize(List<Integer> winningNumbers, Integer bonusNumber) {
        int matchNumberCount = (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
        if (matchNumberCount == 5 && numbers.contains(bonusNumber)) {
            return Prize.FIVE_AND_BONUS;
        }
        return Prize.of(matchNumberCount);
    }
}
