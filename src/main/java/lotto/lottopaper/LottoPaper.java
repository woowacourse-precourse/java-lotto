package lotto.lottopaper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class LottoPaper {
    private static final int ZERO = 0;
    private final List<Lotto> lottos = new ArrayList<>();

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    private List<Integer> initRanks() {
        return new ArrayList<>(Collections.nCopies(Rank.LENGTH, ZERO));
    }

    public List<Integer> checkLottos(List<Integer> userNumbers, Integer bonusNumber) {
        List<Integer> resultRanks = initRanks();

        for (Lotto lotto : lottos) {
            int rank = lotto.getRank(userNumbers, bonusNumber);
            resultRanks.set(rank, resultRanks.get(rank)+1);
        }

        return resultRanks;
    }
}
