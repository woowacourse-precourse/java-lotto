package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        checkSize(lottos);
        this.lottos = lottos;
    }

    public List<Integer> result(BonusLotto bonusLotto) {
        List<Integer> counts = new ArrayList<>();
        for (Lotto lotto : lottos) {
            counts.add(bonusLotto.match(lotto));
        }
        return counts;
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
