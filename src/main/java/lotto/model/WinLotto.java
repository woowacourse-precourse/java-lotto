package lotto.model;

public class WinLotto {

    private final Lotto lotto;

    private final int bonusNumber;

    public WinLotto(Lotto lotto, int bonusNumber) {
        validateDuplicateBonusNumber(lotto, bonusNumber);
        LottoRule.validateRange(bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateDuplicateBonusNumber(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호와 중복되었습니다.");
        }
    }
}
