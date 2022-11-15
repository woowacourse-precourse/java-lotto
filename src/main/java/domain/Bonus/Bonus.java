package domain.Bonus;

import domain.Lotto.Lotto;

public class Bonus {
    private final int bonusNumber;

    public Bonus(int bonusNumber, Lotto lotto) {
        validateRange(bonusNumber);
        validateDuplicateWithLotto(bonusNumber, lotto);
        this.bonusNumber = bonusNumber;
    }

    public void validateRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45 ) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void validateDuplicateWithLotto(int bonusNumber, Lotto lotto) {
        if (lotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
