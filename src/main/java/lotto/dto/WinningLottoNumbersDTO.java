package lotto.dto;

import lotto.domain.Lotto;

public class WinningLottoNumbersDTO {
    private final Lotto winningLotto;
    private final int bonusNumber;
    
    public WinningLottoNumbersDTO(final Lotto winningLotto, final int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }
    
    public Lotto getWinningLotto() {
        return winningLotto;
    }
    
    public int getBonusNumber() {
        return bonusNumber;
    }
}
