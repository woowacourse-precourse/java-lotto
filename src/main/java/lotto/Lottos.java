package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
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
        if (count == 5) {
            bonus = bonusLotto.checkBonus(lotto);
        }
        return bonus;
    }

    private void checkSize(List<Lotto> lottos) {
        if (lottos.size() < 1) {
            throw new IllegalArgumentException("[ERROR] 로또 개수가 1 미만일 수 없어요.");
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
