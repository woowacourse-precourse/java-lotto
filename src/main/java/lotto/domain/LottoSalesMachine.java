package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoSalesMachine {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public List<Lotto> createLottos(int moneyForLottos) {
        return getLottos(moneyForLottos);
    }

    private List<Lotto> getLottos(int moneyForLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < moneyForLottos / LOTTO_PRICE; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT)));
        }
        return lottos;
    }
}
