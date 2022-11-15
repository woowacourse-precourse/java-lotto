package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int START_Inclusive = 1;
    private static final int END_Inclusive = 45;
    private static final int COUNT = 6;

    public static List<Lotto> automatic(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(START_Inclusive, END_Inclusive, COUNT)));
        }
        return lottos;
    }
}
