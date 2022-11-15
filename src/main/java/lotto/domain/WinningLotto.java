package lotto.domain;


public class WinningLotto {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        validateDuplicate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(Lotto lotto,BonusNumber bonusNumber) {
        if (bonusNumber.isDuplicate(lotto)) {
            throw new IllegalArgumentException("보너스 번호는 중복될 수 없습니다");
        }
    }

    public int matchCount(Lotto lotto) {
        return lotto.containsCount(winningLotto);
    }

    public boolean isMatchBonusNumber(Lotto lotto) {
        return bonusNumber.isMatch(lotto);
    }
}
