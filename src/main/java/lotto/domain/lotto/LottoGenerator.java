package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {
    private static final int STARTING_INDEX = 0;

    private final List<List<Integer>> lottos = new ArrayList<>();

    public LottoGenerator(int numOfLotto) {

        for (int i = STARTING_INDEX; i < numOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto.getNumbers());
        }
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }
}
