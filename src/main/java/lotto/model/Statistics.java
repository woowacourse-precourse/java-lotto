package lotto.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Statistics {
    private static final String COUNT_STATE = " - %d개";

    private final List<Lotto> lottos;
    private final WinningLotto winningLotto;
    private Map<Rank, Integer> winningLottoCounter;

    public Statistics(List<Lotto> lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        initMap();
        countRank();
    }

    private void initMap() {
        winningLottoCounter = new LinkedHashMap<>();
        Rank[] values = Rank.values();
        for (Rank value : values) {
            winningLottoCounter.put(value, 0);
        }
    }

    public Map countRank() {
        for (Lotto lotto : lottos) {
            Rank rank = computeRank(lotto);
            winningLottoCounter.put(rank, winningLottoCounter.get(rank) + 1);
        }

        winningLottoCounter.remove(Rank.NOTHING);

        return Collections.unmodifiableMap(winningLottoCounter);
    }

    private Rank computeRank(Lotto lotto) {
        int countOfMatching = winningLotto.countMatchingLottoNumbers(lotto);
        boolean hasBonusNumber = winningLotto.matchBonusNumber(lotto);

        Rank rank = Rank.of(countOfMatching, hasBonusNumber);
        return rank;
    }

    public int computeTotalPrice() {
        Set<Rank> ranks = winningLottoCounter.keySet();
        int totalPrice = 0;

        for (Rank rank : ranks) {
            int price = rank.computePrice(winningLottoCounter.get(rank));
            totalPrice += price;
        }

        return totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder statistics = new StringBuilder();
        Set<Rank> ranks = winningLottoCounter.keySet();
        for (Rank rank : ranks) {
            statistics.append(rank.toString() + getCountString(winningLottoCounter.get(rank)));
            statistics.append("\n");
        }
        statistics.delete(statistics.lastIndexOf("\n"), statistics.length());
        return statistics.toString();
    }

    private String getCountString(int count) {
        return String.format(COUNT_STATE, count);
    }
}
