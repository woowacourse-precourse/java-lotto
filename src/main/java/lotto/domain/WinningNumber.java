package lotto.domain;

import java.util.List;
import lotto.message.ErrorMessage;

public class WinningNumber {
    private final Lotto winningNumber;

    public WinningNumber(final List<Integer> winningNumber) {
        this.winningNumber = new Lotto(winningNumber);
    }

    public void validateBonusNumber(final int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER_ERROR);
        }
    }

    public int getEqualCount(final List<Integer> numbers) {
        List<Integer> winningNumbers = winningNumber.getNumbers();
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
