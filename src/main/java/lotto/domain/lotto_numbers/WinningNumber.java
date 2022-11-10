package lotto.domain.lotto_numbers;

import java.util.List;

public class WinningNumber implements LottoNumbers {

    private final List<Integer> winningNumbers;

    public WinningNumber(List<Integer> winningNumbers) {
        validate(winningNumbers);
        validateDuplication(winningNumbers);
        validateRangeOfNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public boolean contains(int bonusNumber) {
        return winningNumbers.contains(bonusNumber);
    }

    public int matchCounts(Lotto purchasedLotto) {
        return purchasedLotto.matchNumberCounts(winningNumbers);
    }
}
