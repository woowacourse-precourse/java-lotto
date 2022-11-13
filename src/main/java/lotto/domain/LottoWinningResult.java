package lotto.domain;

import java.util.Collections;
import java.util.Map;
import lotto.constant.LottoWinningRanking;

public class LottoWinningResult {
    private final Map<LottoWinningRanking, Integer> numberOfWinningEachRanks;

    public LottoWinningResult(Map<LottoWinningRanking, Integer> numberOfWinningEachRanks) {
        this.numberOfWinningEachRanks = numberOfWinningEachRanks;
    }

    public Map<LottoWinningRanking, Integer> getNumberOfWinningEachRanks() {
        return Collections.unmodifiableMap(numberOfWinningEachRanks);
    }

    public int getTotalWinningMoney() {
        return numberOfWinningEachRanks.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getWinningAmount() * entry.getValue().intValue())
                .sum();
    }
}
