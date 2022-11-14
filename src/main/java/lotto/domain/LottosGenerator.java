package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottosGenerator {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int MAX_LENGTH = 6;

    public static List<List<Integer>> lottoGenerate(int count) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, MAX_LENGTH);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto.getNumbers());
        }
        return lottos;
    }

}
