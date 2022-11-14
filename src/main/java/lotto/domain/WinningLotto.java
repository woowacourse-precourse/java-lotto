package lotto.domain;

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
            throw new IllegalArgumentException(Message.ALREADY_CONTAINS_BONUS_NUMBER);
        }

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(Message.RANGE_OF_NUMBER);
        }
    }

    public int matchCount(Lotto compareLotto){
        return compareLotto.countMatchingNumber(lotto);
    }

    public boolean isContainsBonusNumber(Lotto compareLotto, int bonusNumber) {
        return compareLotto.containsNumber(bonusNumber);
    }
}
