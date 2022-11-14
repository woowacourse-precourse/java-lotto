package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.type.Prize;

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
    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Prize compareWinningNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        List<Integer> matchWinningNumbers = numbers.stream()
                .filter(winningNumbers::contains)
                .collect(Collectors.toList());
        if (matchWinningNumbers.size() == 5) {
            long count = numbers.stream()
                    .filter(bonusNumber::equals)
                    .count();
            if (count == 1) {
                return Prize.FIVE_AND_BONUS;
            }
            return Prize.FIVE;
        }
        return Prize.of(matchWinningNumbers.size());
    }
}
