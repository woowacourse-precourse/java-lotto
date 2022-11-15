package lotto.domain;

import static lotto.domain.LottoValidator.validateLottoNumbers;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int checkRank(List<Integer> winningNumbers, int bonusNumber) {
        int count = 0;

        count += winningNumbers.stream()
                .filter(numbers::contains)
                .count();

        if (isSecond(count, bonusNumber)) {
            count = 7;
        }

        return count;
    }

    private boolean isSecond(int count, int bonusNumber) {
        return count == 5 && numbers.contains(bonusNumber);
    }
}
