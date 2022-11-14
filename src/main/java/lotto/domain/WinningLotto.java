package lotto.domain;


public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validateDuplicate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(Lotto lotto,int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 중복될 수 없습니다");
        }
    }

    public int matchCount(Lotto lotto) {
        return lotto.containsCount(winningLotto);
    }

    public boolean isMatchBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
