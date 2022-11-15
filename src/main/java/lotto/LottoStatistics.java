package lotto;

import static lotto.Rank.values;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private static final int INIT_COUNT = 0;
    private static final int ONE_COUNT = 1;

    private final WinningLotto winningLotto;
    private final List<Lotto> lottos;
    private final Map<Rank, Integer> statistics = new EnumMap<>(Rank.class);

    public LottoStatistics(WinningLotto winningLotto, List<Lotto> lottos) {
        this.winningLotto = winningLotto;
        this.lottos = lottos;

        initStatistics();

        updateStatistics();
    }

    private void initStatistics() {
        for (Rank rank : values()) {
            statistics.put(rank, INIT_COUNT);
        }
    }

    private void updateStatistics() {
        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.getRankOfLotto(lotto);

            statistics.put(rank, addCount(rank));
        }
    }

    private int addCount(Rank rank) {
        return statistics.get(rank) + ONE_COUNT;
    }
}
