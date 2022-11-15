package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    private static final Integer START = 1;
    private static final Integer END = 45;
    private static final Integer COUNT = 6;

    public static List<Lotto> generateLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(START, END, COUNT));
            lottos.add(lotto);
        }

        return lottos;
    }

}
