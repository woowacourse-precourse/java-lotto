package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import static lotto.utils.Constants.*;

public class WinningStatics {
    private final LinkedHashMap<LottoResult, Long> lottoResults = new LinkedHashMap<>();
    private float lateOfReturn;

    public WinningStatics() {
        makeLottoResult();
    }

    private void makeLottoResult() {
        Arrays.stream(LottoResult.values())
                .filter(LottoResult::isNotFailed)
                .forEach(lottoResult -> lottoResults.put(lottoResult, 0L));
    }

    public void calculateRateOfReturn(int purchaseMoney) {
        long prizeMoney = calculatePrizeMoney();
        this.lateOfReturn = Math.round((float) prizeMoney / purchaseMoney * 1000) / 10f;
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
                .map(entry -> entry.getKey().toString() + entry.getValue() + COUNT_UNIT_MESSAGE)
                .collect(Collectors.joining(LF))
                + LF + TOTAL_RATE_OF_RETURN + lateOfReturn + UNIT_OF_RATE_OF_RETURN + LF;
    }
}
