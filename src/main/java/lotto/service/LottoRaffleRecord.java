package lotto.service;

import lotto.config.LottoPrize;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoRaffleRecord {

    private final Map<String, Integer> prizeRecord;
    private int winningMoney;

    public LottoRaffleRecord() {
        prizeRecord = new LinkedHashMap<>();
        initPrizeRecordByLottoRules();
    }

    private void initPrizeRecordByLottoRules() {
        Arrays.stream(LottoPrize.values()).forEach(prize -> prizeRecord.put(prize.name(), 0));
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
        prizeRecord.forEach((prize, count) -> winningMoney += LottoPrize.getWinningsByPrize(prize) * count);
    }

}
