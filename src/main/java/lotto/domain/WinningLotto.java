package lotto.domain;

import java.util.List;

import static lotto.domain.ErrorType.ERROR_WINNING_LOTTO_CONTAIN_BONUS;

public class WinningLotto {
    private final Lotto winningLotto;
    private final Bonus bonus;

    public WinningLotto(Lotto winningLotto, Bonus bonus) {
        validateWinningLottoContainsBonusNumber(winningLotto, bonus);
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    private void validateWinningLottoContainsBonusNumber(Lotto winningLotto, Bonus bonus) {
        if (winningLotto.containsBonusNumber(bonus.getNumber())) {
            throw new IllegalArgumentException(ERROR_WINNING_LOTTO_CONTAIN_BONUS.getErrorMessage());
        }
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonus.getNumber();
    }
}