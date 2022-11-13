package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Seller {

    public static LottoTicket buyLottoByMoney(Money money) {
        return new LottoTicket(toLottos(money));
    }

    private static List<Lotto> toLottos(Money money) {
        int lottoQuantity = money.getQuantityByUnit(1000);
        List<Lotto> lottos = new ArrayList<>();
        while (lottoQuantity-- != 0) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }
}
