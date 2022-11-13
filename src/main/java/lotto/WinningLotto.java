package lotto;

import java.util.List;

public class WinningLotto extends Lotto {
    private final int bonus;

    public WinningLotto(List<Integer> winningNumber, int bonus) {
        super(winningNumber);
        if (this.checkContains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호랑 중복될 수 없어요.");
        }
        this.checkLottoRange(bonus);
        this.bonus = bonus;
    }

    public boolean checkBonus(Lotto lotto) {
        return lotto.checkContains(bonus);
    }
}
