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

        return lottos;
    }

    private void validateMoney(long money) {
        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 돈은 양수여야 합니다.");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 돈은 1000원 단위여야 합니다.");
        }
    }

    private Lotto buyOne() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumber);
    }
}
