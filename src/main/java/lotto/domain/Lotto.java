package lotto.domain;

import static lotto.domain.LottoValidator.validateLottoNumbers;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private static final int SECOND = 7;

    private static final int THIRD = 5;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int checkRank(List<Integer> winningNumbers, int bonusNumber) {
        int count = 0;

        count += winningNumbers.stream()
                .filter(numbers::contains)
                .count();

        if (isSecond(count, bonusNumber)) {
            count = SECOND;
        }

        return count;
    }

    private boolean isSecond(int count, int bonusNumber) {
        return count == THIRD && numbers.contains(bonusNumber);
    }
}
