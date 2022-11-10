package lotto.domain;

public class WinningLottoNumbers {
    private final Lotto winningLotto;
    private final int bonusNumber;
    
    public WinningLottoNumbers(final Lotto winningLotto, final int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }
    
    public int countOfMatchingNumber(final Lotto lotto) {
        return lotto.countOfMatchingNumber(winningLotto);
    }
    
    public boolean isBonusNumberExist(final Lotto lotto) {
        return lotto.isNumberContains(bonusNumber);
    }
}
