package lotto.model;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class RankCount {
    private final List<Lotto> lottos;
    private final WinningLotto winningLotto;
    private EnumMap<Rank, Integer> winningLottoCounter;

    public RankCount(List<Lotto> lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        initWinningLottoCounter();
    }

    private void initWinningLottoCounter() {
        winningLottoCounter = new EnumMap<Rank, Integer>(Rank.class);
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            winningLottoCounter.put(rank, 0);
        }
    }

    public Map countRank() {
        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.computeRank(lotto);
            winningLottoCounter.put(rank, winningLottoCounter.getOrDefault(rank, 0) + 1);
        }

        winningLottoCounter.remove(Rank.NOTHING);

        return Collections.unmodifiableMap(winningLottoCounter);
    }
}
