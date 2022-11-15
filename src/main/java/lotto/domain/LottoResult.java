package lotto.domain;

import lotto.domain.winning.WinningRank;

import java.util.Collections;
import java.util.Map;

public class LottoResult {

    private final Map<WinningRank, Integer> result;

    public LottoResult(Map<WinningRank, Integer> result) {
        this.result = result;
    }

    public double calculateYield(Wallet wallet) {
        int money = wallet.getMoney();

        int proceeds = calculateProceeds();

        return Math.floor(((double) proceeds / money) * 100);
    }

    private int calculateProceeds() {
        return result.keySet()
                .stream()
                .mapToInt(WinningRank::getPrize)
                .sum();
    }

    public Map<WinningRank, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
