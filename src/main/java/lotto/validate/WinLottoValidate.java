package lotto.validate;

import lotto.domain.Lotto;
import lotto.enums.IntEnum;

import static lotto.enums.IntEnum.*;

public class WinLottoValidate {
    public void validate(Lotto winLotto, int bonus) {
        lottoBonusDuplicateValidate(winLotto, bonus);
        bonusRangeValidate(bonus);
    }
    private void lottoBonusDuplicateValidate(Lotto winLotto, int bonus) {
        if (winLotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복됩니다.");
        }
    }
    public void bonusRangeValidate(int bonus) {
        if (bonus < START_NUMBER.getValue() || bonus > LAST_NUMBER.getValue()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 범위 밖의 숫자입니다.");
        }
    }
}
