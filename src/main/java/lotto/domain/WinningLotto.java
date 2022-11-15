package lotto.domain;

public class WinningLotto {
    private static final String BONUS_NUMBER_DUPLICATION_ERROR = "[ERROR] 보너스 번호는 로또 번호에 포함되면 안됩니다.";

    private Lotto winningLotto;
    private int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validate(lotto, bonusNumber);
        this.winningLotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    private void validate(Lotto lotto, int bonusNumber) {
        if (LottoReader.isIncludedNumber(lotto, bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_ERROR);
        }
    }

}
