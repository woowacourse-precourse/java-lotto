package lotto;

public class WinLotto {
    private Lotto lotto;
    private long bonusNumber;

    public WinLotto(Lotto lotto, long bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, long bonusNumber) {
        if (lotto.isExistInNumbers(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
