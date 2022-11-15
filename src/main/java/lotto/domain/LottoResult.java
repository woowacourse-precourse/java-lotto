package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LottoResult {
    private final double money;
    private final double yield;
    private final Map<Rank, Integer> resultMap;

    public LottoResult(UserLottos userLottos, WinningLotto winningLotto) {
        money = userLottos.getUserLottosMoney();
        resultMap = setResultMap(userLottos, winningLotto);
        yield = calculateYield(money);
    }
    public Map<Rank, Integer> setResultMap(UserLottos userLottos, WinningLotto winningLotto) {
        Map<Rank, Integer> resultMap = new HashMap<>();
        Set<Lotto> lottoSet = userLottos.getUserLottos();

        for (Lotto eachLotto : lottoSet) {
            Rank rank = winningLotto.getRankof(eachLotto);
            addToResultMap(rank, resultMap);
        }
        return resultMap;
    }
    public void addToResultMap(Rank rank, Map<Rank, Integer> resultMap) {
        if (rank == null) {
            return;
        }

        int winningCount = resultMap.getOrDefault(rank, 0);
        resultMap.put(rank, winningCount + 1);
    }
    public double calculateYield(double money) {
        long totalPrize = 0;
        for (Rank rank : Rank.values()) {
            int count = resultMap.getOrDefault(rank, 0);
            long prize = rank.getPrize();
            totalPrize += count * prize;
        }

        return Math.round((totalPrize / money) * 1000) / 10.0;
    }

}
