package lotto;

import static java.util.stream.Collectors.toList;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> generateLottos(int countOfLottos) {
        for (int i = 0; i < countOfLottos; i++) {
            List<Integer> numbers
                    = Randoms.pickUniqueNumbersInRange(Lotto.FIRST_NUMBER, Lotto.LAST_NUMBER, Lotto.SIZE);

            Collections.sort(numbers);

            Lotto lotto = new Lotto(numbers);

            lottos.add(lotto);
        }

        return lottos;
    }
}
