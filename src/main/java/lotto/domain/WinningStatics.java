package lotto.domain;

import java.util.Map;
import java.util.stream.Collectors;

public class WinningStatics {
    private final Map<LottoResult, Long> lottoResults;
    private final float lateOfReturn;

    public WinningStatics(Map<LottoResult, Long> lottoResults, int purchaseMoney) {
        this.lottoResults = lottoResults;
        this.lateOfReturn = calculateRateOfReturn(lottoResults, purchaseMoney);
    }

    private float calculateRateOfReturn(Map<LottoResult, Long> lottoResults, int purchaseMoney) {
        long prizeMoney = calculatePrizeMoney(lottoResults);
        return Math.round((float) prizeMoney / purchaseMoney * 100);
    }

    private long calculatePrizeMoney(Map<LottoResult, Long> lottoResults) {
        return lottoResults.entrySet().stream()
                .mapToLong(entry -> entry.getKey().calculatePrizeMoney(entry.getValue()))
                .sum();
    }

    @Override
    public String toString() {
        return lottoResults.entrySet().stream()
                .map(entry -> entry.getKey().toString() + entry.getValue() + "개")
                .collect(Collectors.joining("\n"))
                + "\n총 수익률은 "+ lateOfReturn +"%입니다.\n";
    }
}
