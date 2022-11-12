package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * 장당 1000원에 로또를 판매
 */
public class LottoStore {
    public List<Lotto> sellLotto(int fee) {
        List<Lotto> lottos = new ArrayList<>();
        int theNumberOfLottos = fee/1000;
        for (int i = 0; i < theNumberOfLottos; i++) {
            lottos.add(printLotto());
        }
        return lottos;
    }

    private Lotto printLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
