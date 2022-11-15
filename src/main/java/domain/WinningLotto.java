package domain;

/**
 * 당첨 로또 정보를 관리하는 클래스
 */
public class WinningLotto {

    private Lotto winningLotto;
    private Integer bonusNumber;

    public WinningLotto(Lotto winningLotto, Integer bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, Integer bonusNumber) {
        if (validateBonusNumberNotInLotto(lotto, bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 로또 번호와 중복되어서는 안됩니다.");
        }

        if (!validateBonusNumberInRange(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 [1,45] 사이의 값을 가져야 합니다.");
        }
    }

    private boolean validateBonusNumberNotInLotto(Lotto lotto, Integer bonusNumber) {
        return lotto.hasNumber(bonusNumber);
    }

    private boolean validateBonusNumberInRange(Integer bonusNumber) {
        return 1 <= bonusNumber && bonusNumber <= 45;
    }

    public LottoGrade getCompareResult(Lotto lotto) {
        return LottoGrade.getMatchGrade(winningLotto.getCountOfMatchNumber(lotto), lotto.hasNumber(bonusNumber));
    }
}
