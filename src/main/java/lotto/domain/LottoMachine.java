package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int COUNT_LOTTO_NUMBER = 6;

    final List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> ticketLottos(int money) {
        int lottoCount = money / LOTTO_PRICE;
        for (int idx = 0; idx < lottoCount; idx++) {
            Lotto lotto = new Lotto(createLottoNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    public List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, COUNT_LOTTO_NUMBER);
    }
}
