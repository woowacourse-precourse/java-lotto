package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

import static lotto.domain.LottoSetting.LOTTO_PRICE;

public class LottoResults {
    private final Map<LottoWin, Integer> lottoResults;

    public LottoResults(Map<LottoWin, Integer> lottoResults) {
        this.lottoResults = new EnumMap<>(lottoResults);
    }

    public Map<LottoWin, Integer> getLottoResults() {
        return new EnumMap<>(lottoResults);
    }

    public double totalRate() {
        double totalCost = totalCost();
        if (totalCost == 0.0) {
            return totalCost;
        }
        return totalPrize() / totalCost;
    }

    private long totalCost() {
        return (long) lottoResults.values()
                .stream()
                .reduce(0, Integer::sum) * (long) LOTTO_PRICE.getSetting();
    }

    private long totalPrize() {
        return lottoResults.entrySet()
                .stream()
                .mapToLong(lottoWin -> (long) lottoWin.getKey().getPrize() * lottoWin.getValue())
                .sum();
    }
}
