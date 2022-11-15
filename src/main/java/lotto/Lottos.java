package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static final int BONUS_CHECK_CONDITION = 5;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }


    private boolean checkBonus(WinningLotto bonusLotto, Lotto lotto, int count) {
        boolean bonus = false;
        if (count == BONUS_CHECK_CONDITION) {
            bonus = bonusLotto.checkBonus(lotto);
        }
        return bonus;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
