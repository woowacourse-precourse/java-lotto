package lotto.domain;


import lotto.config.InputConfig;
import lotto.util.LottoComparator;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

public class Statistics {
    private final Lotto prizeLotto;
    private final int bonusNumber;
    private Map<Rank, Integer> result;

    public Statistics(Lotto prizeLotto, int bonusNumber) {
        this.prizeLotto = prizeLotto;
        this.bonusNumber = bonusNumber;
        InputConfig.checkPrizeLottoWithBonus(prizeLotto, bonusNumber);
    }

    private void initResult() {
        Map<Rank, Integer> tmp = new EnumMap<>(Rank.class);
        EnumSet.allOf(Rank.class).forEach(r -> tmp.put(r, 0));
        this.result = tmp;
    }

    long getTotalProfit() {
        long total = result.entrySet().stream().map(e -> e.getKey().getPrizeMoney() * e.getValue()).reduce(0, Integer::sum);
        return total;
    }

    private void matchLotto(List<Lotto> purchased) {
        initResult();
        Map<Rank, Integer> ranked = LottoComparator.compareToPrize(purchased, prizeLotto, bonusNumber);
        ranked.forEach((key, value) -> result.merge(key, value, (v1, v2) -> v1 + v2));
        result.remove(Rank.NONE);
    }

    public Map<Rank, Integer> getResult(List<Lotto> purchased) {
        matchLotto(purchased);
        return result;
    }
}
