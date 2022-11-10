package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final LottoStore instance = new LottoStore();

    private LottoStore() {}
    public static LottoStore getInstance() {
        return instance;
    }

    public List<Lotto> buy(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }

        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < money / 1000; i++) {
            lottos.add(buyOne());
        }

        return lottos;
    }

    private Lotto buyOne() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumber);
    }
}
