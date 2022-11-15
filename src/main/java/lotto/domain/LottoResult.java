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



}
