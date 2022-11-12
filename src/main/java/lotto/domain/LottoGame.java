package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private List<Lotto> lotteries = new ArrayList<>();
    private int lottoCount;

    public int countLotto(int cost) {
        lottoCount = cost / 1000;

        return lottoCount;
    }

    public List<Lotto> createRandomLotto() {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotteries.add(new Lotto(lottoNumber));
        }

        return lotteries;
    }
}
