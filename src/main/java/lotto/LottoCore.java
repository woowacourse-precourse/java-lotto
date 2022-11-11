package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoCore {

    public List<Lotto> createManyLotto(int lottoCount) {

        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto;
        for (int index = 0; index < lottoCount; index++) {
            lotto = createLotto();
            lottos.add(lotto);
        }

        return lottos;
    }

    private Lotto createLotto() {
        Lotto lotto;
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lotto = new Lotto(numbers);
        return lotto;
    }

}
