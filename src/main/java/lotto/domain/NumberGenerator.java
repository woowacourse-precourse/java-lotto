package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class NumberGenerator {
    public static List<Lotto> createLottoList(int lottoCount) {

        List<Lotto> lottos = new ArrayList<Lotto>();
        for (int order = 0; order < lottoCount; order++) {
            List<Integer> numbers = pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }
}
