package lotto.domain.lotto_numbers;

import java.util.List;

public class WinningNumbers implements LottoNumbers {

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validate(winningNumbers);
        validateDuplication(winningNumbers);
        validateRangeOfNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }
}
