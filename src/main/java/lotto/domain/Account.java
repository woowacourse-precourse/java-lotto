package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import lotto.constant.WinningResult;

public class Account {
    private Map<WinningResult, Integer> results = new LinkedHashMap();
    private int count;
    private int winningAmount;

    public Account() {
        this.results.put(WinningResult.RANK_NONE, 0);
        this.results.put(WinningResult.RANK_5, 0);
        this.results.put(WinningResult.RANK_4, 0);
        this.results.put(WinningResult.RANK_3, 0);
        this.results.put(WinningResult.RANK_2, 0);
        this.results.put(WinningResult.RANK_1, 0);
        this.winningAmount = 0;
    }
}
