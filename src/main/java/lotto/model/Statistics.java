package lotto.model;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningLotto;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Statistics {
    private static final String COUNT_STATE = " - %d개";

    private final List<Lotto> lottos;
    private final WinningLotto winningLotto;
    private Map<Rank, Integer> countRanks;

    public Statistics(List<Lotto> lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        initMap();
    }

    private void initMap() {
        countRanks = new LinkedHashMap<>();
        Rank[] values = Rank.values();
        for (Rank value : values) {
            countRanks.put(value, 0);
        }
    }

    public Map countRank() {
        for (Lotto lotto : lottos) {
            Rank rank = computeRank(lotto);
            countRanks.put(rank, countRanks.get(rank) + 1);
        }

        countRanks.remove(Rank.NOTHING);

        return Collections.unmodifiableMap(countRanks);
    }

    private Rank computeRank(Lotto lotto) {
        int countOfMatching = winningLotto.countMatchingLottoNumbers(lotto);
        boolean hasBonusNumber = winningLotto.matchBonusNumber(lotto);

        Rank rank = Rank.of(countOfMatching, hasBonusNumber);
        return rank;
    }
}
