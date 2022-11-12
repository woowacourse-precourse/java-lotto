package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static final int MINIMUM_LOTTOS_SIZE = 1;
    private static final int BONUS_CHECK_CONDITION = 5;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        checkSize(lottos);
        this.lottos = lottos;
    }

    public List<LottoOperator> result(BonusLotto bonusLotto) {
        List<LottoOperator> winningRanks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int count = bonusLotto.match(lotto);
            boolean bonus = checkBonus(bonusLotto, lotto, count);
            winningRanks.add(LottoOperator.find(count, bonus));
        }
        return winningRanks;
    }

    private boolean checkBonus(BonusLotto bonusLotto, Lotto lotto, int count) {
        boolean bonus = false;
        if (count == BONUS_CHECK_CONDITION) {
            bonus = bonusLotto.checkBonus(lotto);
        }
        return bonus;
    }

    private void checkSize(List<Lotto> lottos) {
        if (lottos.size() < MINIMUM_LOTTOS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 개수가 1 미만일 수 없어요.");
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
