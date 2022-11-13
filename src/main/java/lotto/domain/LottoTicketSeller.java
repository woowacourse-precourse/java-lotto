package lotto.domain;

import static lotto.domain.Lotto.LOTTO_BALL_SIZE;
import static lotto.domain.Lotto.MAX_LOTTO_NUMBER;
import static lotto.domain.Lotto.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoTicketSeller {

    public static final int LOTTO_PRICE = 1000;

    public static LottoTicket buyLottoByMoney(LottoMoney money) {
        return new LottoTicket(toLottos(money));
    }

    private static List<Lotto> toLottos(LottoMoney money) {
        long lottoQuantity = money.getQuantityByUnit(LOTTO_PRICE);
        List<Lotto> lottos = new ArrayList<>();
        while (lottoQuantity-- != 0) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_BALL_SIZE)));
        }
        return lottos;
    }
}