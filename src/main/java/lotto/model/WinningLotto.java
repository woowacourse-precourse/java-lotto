package lotto.model;

import static lotto.exception.WinningLottoException.isDuplicatedWithWinningNumbers;
import static lotto.exception.WinningLottoException.isValidInputPattern;
import static lotto.exception.WinningLottoException.isValidNumberRange;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(String winningLotto, int bonusNumber) {
        isValidInputPattern(winningLotto);
        this.winningLotto = convert(winningLotto);
        isDuplicatedWithWinningNumbers(this.winningLotto, bonusNumber);
        isValidNumberRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private Lotto convert(String winningLotto) {
        return new Lotto(Arrays.stream(winningLotto.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public boolean isContain(int number) {
        return this.winningLotto.isContain(number);
    }
}
