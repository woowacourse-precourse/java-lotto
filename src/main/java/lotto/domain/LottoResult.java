package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class LottoResult {
    private final HashMap<Rank, Integer> lottoResult;

    public LottoResult(List<Lotto> lottos, WinningNums winNums) {
        lottoResult = createLottoResult(lottos, winNums);
    }

    public HashMap<Rank, Integer> init() {
        HashMap<Rank, Integer> init = new HashMap<>();
        for (Rank rank : Rank.values()) {
            init.put(rank, 0);
        }
        return init;
    }

    public HashMap<Rank, Integer> createLottoResult(List<Lotto> lottos, WinningNums winningNums) {
        HashMap<Rank, Integer> result = init();
        for (Lotto lotto : lottos) {
            Rank rank = Rank.get(lotto.countSameNum(winningNums), lotto.isContainsBonus(winningNums));
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }

    public long getTotalPrize() {
        long totalPrize = 0;
        for (Rank rank : lottoResult.keySet()) {
            totalPrize += rank.getPrize() * lottoResult.get(rank);
        }
        return totalPrize;
    }

    public HashMap<Rank, Integer> get() {
        return lottoResult;
    }
}
