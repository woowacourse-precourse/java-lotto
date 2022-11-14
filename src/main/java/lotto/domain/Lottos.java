package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void generateLottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
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

    private void add(Lotto lotto) {
        lottos.add(lotto);
    }
}
