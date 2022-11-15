package lotto.domain.statistics;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinLotto;

public class Result {

    private final Map<Rank, Integer> result = new HashMap<>();

    public Result(Lottos lottos, WinLotto winLotto) {
        for (Lotto lotto : lottos.get()) {
            Rank rank = Rank.of(lotto.getEqualCount(winLotto),
                lotto.contains(winLotto.getBonus()));
            put(rank);
        }
    }

    public static Result of(Lottos lottos, WinLotto winLotto) {
        return new Result(lottos, winLotto);
    }

    private void put(Rank rank) {
        result.merge(rank, 1, Integer::sum);
    }

    public Map<Rank,Integer> get(){
        return result;
    }

    public int getRankCount(Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    public long getPrize() {
        long sum = 0;
        for (Rank rank : result.keySet()) {
            sum += (long) rank.getPrize().get() * result.get(rank);
        }
        return sum;
    }
}
