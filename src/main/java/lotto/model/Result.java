package lotto.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Result {
    private final Map<Rank, Integer> result = new LinkedHashMap<>();

    public Result(Lottos lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos.getLottos()) {
            Rank rank = Rank.of(lotto.countSameNumber(winningLotto), lotto.isContain(winningLotto.getBonusNumber()));
            this.result.put(rank, this.result.getOrDefault(rank, 0) + 1);
        }
    }

    public int getRankCount(Rank rank) {
        return this.result.getOrDefault(rank, 0);
    }
}
