package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoGenerator {

    private LottoGenerator() {}

    public static List<Lotto> generateLotto(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i=0; i<lottoCount; i++) {
            lottos.add(new Lotto(get6Numbers()));
        }
        return lottos;
    }

    public static List<Integer> get6Numbers() {
        List<Integer> numbersInRange = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        numbersInRange.sort(Comparator.naturalOrder());
        return numbersInRange;
    }
}
