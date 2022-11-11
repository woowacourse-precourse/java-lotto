package lotto.domain;

import lotto.validator.domain.BonusNumberValidator;

public class WinningLottoNumbers {
    private final Lotto winningLotto;
    private final int bonusNumber;
    
    public WinningLottoNumbers(final Lotto winningLotto, final int bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);
        
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }
    
    private void validateBonusNumber(final Lotto winningLotto, final int bonusNumber) {
        BonusNumberValidator.validate(winningLotto, bonusNumber);
    }
    
    public int countOfMatchingNumber(final Lotto lotto) {
        return lotto.countOfMatchingNumber(winningLotto);
    }
    
    public boolean isBonusNumberExist(final Lotto lotto) {
        return lotto.isNumberContains(bonusNumber);
    }
    
    @Override
    public String toString() {
        return "WinningLottoNumbers{" +
                "winningLotto=" + winningLotto +
                ", bonusNumber=" + bonusNumber +
                '}';
    }
}
