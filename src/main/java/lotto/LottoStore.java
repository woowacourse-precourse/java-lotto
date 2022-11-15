package lotto;

import static lotto.Lotto.MAX_NUMBER;
import static lotto.Lotto.MIN_NUMBER;
import static lotto.Lotto.SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    public static final int PRICE = 1000;

    public static Lottos byLottos(LottoMoney money) {
        return new Lottos(of(money));
    }

    private static List<Lotto> of(LottoMoney money) {
        long lottosCount = money.lottosCount(PRICE);
        List<Lotto> lottos = new ArrayList<>();
        while (lottosCount-- > 0) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, SIZE)));
        }
        return lottos;
    }
}
