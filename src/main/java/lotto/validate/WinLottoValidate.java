package lotto.validate;

import lotto.domain.Lotto;
import lotto.enums.IntEnum;

import java.util.List;

import static lotto.enums.IntEnum.*;

public class WinLottoValidate {
    public void validate(List<Integer> numbers, int bonus) {
        lottoBonusDuplicateValidate(numbers, bonus);
        bonusRangeValidate(bonus);
    }
    private void lottoBonusDuplicateValidate(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복됩니다.");
        }
    }
    public void bonusRangeValidate(int bonus) {
        if (!isRangeIn(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 범위 밖의 숫자입니다.");
        }
    }
}
