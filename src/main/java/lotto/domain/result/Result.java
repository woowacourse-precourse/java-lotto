package lotto.domain.result;

import java.util.LinkedHashMap;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

public class Result {
    private final Map<Rank, Integer> result = new LinkedHashMap<>();

    public Result(Lottos lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos.getLottos()) {
            Rank rank = Rank.of(lotto.countSameNumber(winningLotto), lotto.isContain(winningLotto.getBonusNumber()));
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }

    public int getRankCount(Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    public int getWinnings() {
        int winnings = 0;
        for (Rank rank : result.keySet()) {
            winnings += rank.getWinnings() * result.get(rank);
        }
        return winnings;
    }
}
