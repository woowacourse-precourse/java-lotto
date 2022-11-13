package service;

import domain.Bonus;
import domain.Lotto;

public class BonusService {
    public Bonus createBonusNumber(int bonusNumber, Lotto lotto) {
        if (!isNotLottoNumbers(bonusNumber, lotto))
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        return new Bonus(bonusNumber);
    }

    public boolean isNotLottoNumbers(int bonusNumber, Lotto lotto) {
        if (lotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
        return true;
    }
}
