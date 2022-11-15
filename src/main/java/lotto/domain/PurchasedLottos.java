package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.CommonValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PurchasedLottos {
    private final int lottoCount;

    private final List<Lotto> lottos;

    public PurchasedLottos(int payment) {
        this.lottoCount = calculateLottoCount(payment);
        this.lottos = generateLottos(this.lottoCount);
    }

    private int calculateLottoCount(int payment) {
        return payment / CommonValue.LOTTO_PRICE;
    }

    private List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount / CommonValue.LOTTO_PRICE; i++) {
            List<Integer> numbers=Randoms.pickUniqueNumbersInRange(CommonValue.MIN_LOTTO_NUMBER, CommonValue.MAX_LOTTO_NUMBER, 6);
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
