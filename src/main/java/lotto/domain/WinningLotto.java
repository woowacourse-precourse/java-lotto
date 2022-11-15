package lotto.domain;

public class WinningLotto {
    private static final String ERROR_DUPLICATED_BONUS_NUMBER = "[ERROR] 보너스 번호와 당첨 번호는 중복될 수 없습니다.";
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        validateDuplication(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplication(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.getLottoNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_DUPLICATED_BONUS_NUMBER);
        }
    }
}