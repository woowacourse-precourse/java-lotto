package lotto.domain.dto;

import lotto.domain.BonusNumber;
import lotto.domain.WinningNumber;

public class TotalWinningLottoDto {
    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public TotalWinningLottoDto(final WinningNumber winningNumber, final BonusNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumber getWinningNumber() {
        return winningNumber;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
