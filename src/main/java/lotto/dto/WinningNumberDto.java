package lotto.dto;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;

public class WinningNumberDto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningNumberDto(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
