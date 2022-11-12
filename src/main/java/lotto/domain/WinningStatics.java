package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class WinningStatics {
    private final LinkedHashMap<LottoResult, Long> lottoResults = new LinkedHashMap<>();
    private final float lateOfReturn;

    public WinningStatics(int purchaseMoney) {
        makeLottoResult();
        this.lateOfReturn = calculateRateOfReturn(purchaseMoney);
    }

    private void makeLottoResult() {
        Arrays.stream(LottoResult.values())
                .filter(LottoResult::isNotFailed)
                .forEach(lottoResult -> lottoResults.put(lottoResult, 0L));
    }

    private float calculateRateOfReturn(int purchaseMoney) {
        long prizeMoney = calculatePrizeMoney();
        return Math.round((float) prizeMoney / purchaseMoney * 100);
    }

    private long calculatePrizeMoney() {
        return lottoResults.entrySet().stream()
                .mapToLong(entry -> entry.getKey().calculatePrizeMoney(entry.getValue()))
                .sum();
    }

    public void updateLottoResults(LottoResult lottoResult) {
        lottoResults.put(lottoResult, lottoResults.get(lottoResult) + 1);
    }

    @Override
    public String toString() {
        return lottoResults.entrySet().stream()
                .map(entry -> entry.getKey().toString() + entry.getValue() + "개")
                .collect(Collectors.joining("\n"))
                + "\n총 수익률은 "+ lateOfReturn +"%입니다.\n";
    }
}
