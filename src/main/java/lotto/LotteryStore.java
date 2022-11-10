package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LotteryStore {
    private static final LotteryStore instance = new LotteryStore();

    private LotteryStore() {}
    public static LotteryStore getInstance() {
        return instance;
    }

    public List<Lotto> buy(int money) {
        validateMoney(money);

        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = money / 1000;
        for(int i = 0; i < lottoCount; i++) {
            lottos.add(buyOne());
        }

        System.out.println(lottoCount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }

        return lottos;
    }

    private void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private Lotto buyOne() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumber);
    }
}
