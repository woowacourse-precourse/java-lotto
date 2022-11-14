package lotto.domain;

import lotto.ui.ErrorMessage;
import lotto.ui.LottoValidator;
import lotto.util.Log;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            Log.error(ErrorMessage.INVALID_SIZE.getMessage());
            throw new IllegalArgumentException(ErrorMessage.INVALID_SIZE.getMessage());
        }

        if (LottoValidator.isDuplication(numbers)) {
            Log.error(ErrorMessage.LOTTO_DUPLICATION.getMessage());
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATION.getMessage());
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
