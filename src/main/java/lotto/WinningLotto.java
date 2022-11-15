package lotto;

import java.util.Collections;
import java.util.Map;

public class WinningLotto {

    private final Map<Rank, Integer> lottoResult;

    public WinningLotto(Map<Rank, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public Map<Rank, Integer> getGradesResult() {
        return Collections.unmodifiableMap(lottoResult);
    }

    public double calculateYield(LottoMoney money) {
        return totalAmountWinning() / money.getMoney();
    }

    private double totalAmountWinning() {
        return lottoResult.keySet().stream()
                .mapToDouble(this::calculatePrizeMoney)
                .sum();
    }

    private long calculatePrizeMoney(Rank rank) {
        return rank.amount().getMoney() * lottoResult.get(rank);
    }
}
