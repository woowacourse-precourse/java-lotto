package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {
    private static final int STARTING_INDEX = 0;
    private static final int FIRST_LOTTO_NUMBER = 1;
    private static final int LAST_LOTTO_NUMBER = 45;
    private static final int TOTAL_LOTTO_NUMBER = 6;

    private final List<List<Integer>> lottos = new ArrayList<>();

    public LottoGenerator(int numOfLotto) {
        for (int i = STARTING_INDEX; i < numOfLotto; i++) {
            List<Integer> numbers
                    = Randoms.pickUniqueNumbersInRange(FIRST_LOTTO_NUMBER, LAST_LOTTO_NUMBER, TOTAL_LOTTO_NUMBER);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto.getNumbers());
        }
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }
}
