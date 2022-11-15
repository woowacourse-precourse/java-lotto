package lotto.result;

import lotto.Lotto;
import lotto.WinningNumbers;

import java.util.LinkedHashMap;
import java.util.List;

public class LotteryResult {

    private final LinkedHashMap<Rank, Integer> result = new LinkedHashMap<>();

    private LotteryResult(List<Lotto> lottos, WinningNumbers winNumbers) {
        validate(lottos);
        for (Lotto lotto : lottos) {
            Rank rank = Rank.of(lotto.countSameNum(winNumbers), lotto.contains(winNumbers.getBonus()));
            add(rank);
        }
    }

    private void add(Rank rank) {
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }

    private void validate(List<Lotto> lottos) {
        if (lottos.size() == 0)
            throw new IllegalArgumentException("[ERROR]");
    }

    public static LotteryResult of(List<Lotto> lottos, WinningNumbers winNumbers) {
        return new LotteryResult(lottos, winNumbers);
    }

    public long getPrize() {
        long prize = 0;
        for (Rank rank : result.keySet()) {
            prize += (long) rank.getPrize() * result.get(rank);
        }
        return prize;
    }



}
