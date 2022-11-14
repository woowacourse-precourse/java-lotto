package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_START_RANGE = 1;
    private static final int LOTTO_END_RANGE = 45;
    private List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void generateLottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_START_RANGE, LOTTO_END_RANGE, LOTTO_NUMBER_SIZE)));
        }
    }

    public Lottos checkLottos() {
        Lottos purchasedLottos = new Lottos();
        for (Lotto lotto : lottos) {
            List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(sortedNumbers);
            purchasedLottos.add(new Lotto(sortedNumbers));
        }
        return purchasedLottos;
    }

    public Results generateResults(Lotto winningLotto, Bonus bonus) {
        Results results = new Results();

        for (Lotto lotto : lottos) {
            results.addResult(lotto.generateResult(winningLotto, bonus));
        }
        return results;
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }
}
