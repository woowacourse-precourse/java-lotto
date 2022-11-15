package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static final int BONUS_CHECK_CONDITION = 5;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Ranking> result(WinningLotto bonusLotto) {
        List<Ranking> winningRanks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int count = lotto.countMatchingNumbers(bonusLotto);
            boolean bonus = checkBonus(bonusLotto, lotto, count);
            winningRanks.add(Ranking.find(count, bonus));
        }
        return winningRanks;
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
