package lotto.domain;

public class WinningNumbers {
    private static final String BONUS_DUPLICATE_LOTTO = "[ERROR] 보너스 숫자는 입력한 로또 번호들과 중복되지 않아야 합니다.";

    private Lotto lotto;
    private int bonusNumber;

    public WinningNumbers(Lotto lotto, int bonusNumber) {
        checkDuplicateNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void checkDuplicateNumber(Lotto lotto, int bonusNumber) {
        if (lotto.containNumber(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE_LOTTO);
        }
    }
}
