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

    public List<Lotto> buy(long money) {
        validateMoney(money);

        List<Lotto> lottos = new ArrayList<>();
        long lottoCount = money / 1000;
        for(int i = 0; i < lottoCount; i++) {
            lottos.add(buyOne());
        }

        System.out.println(lottoCount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }

        return lottos;
    }

    private void validateMoney(long money) {
        if (money <= 0 || money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private Lotto buyOne() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumber);
    }
}
