package lotto.model;

import lotto.config.LottoPrizeRules;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static lotto.config.Constants.LottoPrizeFilter.NOT_ALLOWED_RECORD_PRIZE;

public class LottoRaffleRecord {

    private final Map<String, Integer> prizeRecord;
    private int winningMoney;

    public LottoRaffleRecord() {
        prizeRecord = new LinkedHashMap<>();
        initByLottoPrizeRules();
    }

    private void initByLottoPrizeRules() {
        Arrays.stream(LottoPrizeRules.values()).forEach(prize -> initRecord(prize.name()));
    }

    private void initRecord(String prize) {
        if (checkRecordAllowed(prize)) {
            prizeRecord.put(prize, 0);
        }
    }

    private boolean checkRecordAllowed(String prize) {
        if (NOT_ALLOWED_RECORD_PRIZE.contains(prize)) {
            return false;
        }
        return true;
    }

    public void updatePrizeRecord(String key) {
        prizeRecord.put(key, prizeRecord.get(key) + 1);
    }

    public Map<String, Integer> getPrizeRecord() {
        return prizeRecord;
    }

    public int getWinnings() {
        collectWinnings();
        return winningMoney;
    }

    private void collectWinnings() {
        prizeRecord.forEach((prize, count) -> winningMoney += LottoPrizeRules.getWinningsByPrize(prize) * count);
    }

}
