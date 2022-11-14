package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class WinningStatistics {
    private final Map<Rank, Integer> winningStatistics;

    public WinningStatistics(PurchasedLottos purchasedLottos, WinningLotto winningLotto) {
        this.winningStatistics = new EnumMap<>(Rank.class);
        initWinningStatistics();
        calculateWinningStatistics(purchasedLottos, winningLotto);
    }

    public Map<Rank, Integer> getWinningStatistics() {
        return winningStatistics;
    }

    private void initWinningStatistics() {
        Arrays.stream(Rank.values())
                .forEach(rank -> winningStatistics.put(rank, 0));
    }

    private void calculateWinningStatistics(PurchasedLottos purchasedLottos, WinningLotto winningLotto) {
        for (Lotto purchasedLotto: purchasedLottos.getLottos()) {
            Rank rank = Rank.getRank(purchasedLotto, winningLotto);
            winningStatistics.put(rank, winningStatistics.get(rank) + 1);
        }
    }
}
