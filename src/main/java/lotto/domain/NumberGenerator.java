package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public static List<Lotto> createLottoList(int lottoCount) {

        List<Lotto> boughtLotto = new ArrayList<Lotto>();
        for (int order = 0; order < lottoCount; order++) {
            List<Integer> numbers = pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            boughtLotto.add(lotto);
        }
        return boughtLotto;
    }
}
