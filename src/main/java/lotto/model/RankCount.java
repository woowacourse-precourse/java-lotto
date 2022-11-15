package lotto.model;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class RankCount {
    private final List<Lotto> lottos;
    private final WinningLotto winningLotto;
    private EnumMap<Rank, Integer> rankCounter;

    public RankCount(List<Lotto> lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        initWinningLottoCounter();
    }

    private void initWinningLottoCounter() {
        rankCounter = new EnumMap<Rank, Integer>(Rank.class);
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            rankCounter.put(rank, 0);
        }
    }

    public Map<Rank, Integer> countRank() {
        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.computeRank(lotto);
            rankCounter.put(rank, rankCounter.getOrDefault(rank, 0) + 1);
        }

        rankCounter.remove(Rank.NOTHING);

        return Collections.unmodifiableMap(rankCounter);
    }
}
