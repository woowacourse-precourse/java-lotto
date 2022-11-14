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
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 이미 로또 번호에 포함됩니다.");
        }

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 1과45 사이의 숫자가 입력되어야 합니다.");
        }
    }

    public int matchCount(Lotto compareLotto){
        return compareLotto.countMatchingNumber(lotto);
    }

    public boolean isContainsBonusNumber(Lotto compareLotto, int bonusNumber) {
        return compareLotto.containsNumber(bonusNumber);
    }
}
