package lotto.domain;

import lotto.ui.LottoValidator;

import java.util.List;

import static lotto.ui.ErrorMessage.INVALID_SIZE;
import static lotto.ui.ErrorMessage.LOTTO_DUPLICATION;
import static lotto.util.LogLevel.ERROR;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_SIZE.toMessage(ERROR));
        }

        if (LottoValidator.isDuplication(numbers)) {
            throw new IllegalArgumentException(LOTTO_DUPLICATION.toMessage(ERROR));
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public LottoMatch matchedCount(List<Integer> winningNumber, Integer bonusNumber) {
        int count = (int) numbers.stream().filter(winningNumber::contains).count();

        if (isBonusLotto(count, bonusNumber)) {
            return LottoMatch.BONUS;
        }

        return LottoMatch.match(count);
    }

    public boolean isBonusLotto(int matchedCount, Integer bonusNumber) {

        return matchedCount == 5 && numbers.contains(bonusNumber);
    }
}
