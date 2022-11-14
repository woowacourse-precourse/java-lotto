package lotto.model.dto;

import lotto.model.domain.BonusNumber;
import lotto.model.domain.Lotto;

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
