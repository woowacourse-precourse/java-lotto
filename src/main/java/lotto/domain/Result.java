package lotto.domain;

import java.util.HashMap;
import java.util.Map;

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
        result.merge(rank, 1, (v1, v2) -> v1 + v2);
    }

    public int getRankCount(Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    public long getPrize(){
        long prize = 0;
        for(Rank rank : result.keySet()){
            prize += rank.getPrize() * result.get(rank);
        }
        return prize;
    }
}
