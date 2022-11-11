package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Seller {

    public static LottoTicket buyLottoByMoney(Money money) {
        return new LottoTicket(toLottos(money));
    }

    private static List<Lotto> toLottos(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        while (money.hasMoney()) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            money.buyLotto(1000);
        }
        return lottos;
    }
}
