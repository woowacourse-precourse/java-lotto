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
        for (int i = 0; i < caculateTheNumberOfLottos(fee); i++) {
            lottos.add(printLotto());
        }
        return lottos;
    }

    private int caculateTheNumberOfLottos(int fee) {
        return fee/1000;
    }

    private Lotto printLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
