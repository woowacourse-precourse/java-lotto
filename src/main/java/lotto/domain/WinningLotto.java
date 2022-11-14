package lotto;

public class WinningLotto {
    private Lotto lotto;
    private int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, int bonusNumber) {
        if (lotto.containsNumber(bonusNumber)) {
            throw new IllegalArgumentException();
        }

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
    }

    public int matchCount(Lotto compareLotto){
        return compareLotto.countMatchingNumber(lotto);
    }

    public boolean isContainsBonusNumber(Lotto compareLotto, int bonusNumber) {
        return compareLotto.containsNumber(bonusNumber);
    }
}
