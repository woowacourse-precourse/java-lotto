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




}
