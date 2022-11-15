package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int START_Inclusive = 1;
    private static final int END_Inclusive = 45;
    private static final int COUNT = 6;
    private static final int PRICE = 1000;

    public static List<Lotto> automatic(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(START_Inclusive, END_Inclusive, COUNT)));
        }
        return lottos;
    }

    public static int maximum(int money) {
        if (money % PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원으로 나누어 떨어지지 않습니다.");
        }
        return money / PRICE;
    }
}
