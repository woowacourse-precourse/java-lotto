package lotto.validate;

import lotto.domain.Lotto;

public class WinLottoValidate {
    public void validate(Lotto winLotto, int bonus) {
        lottoBonusDuplicateValidate(winLotto, bonus);
    }
    private void lottoBonusDuplicateValidate(Lotto winLotto, int bonus) {
        if (winLotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복됩니다.");
        }
    }
}
