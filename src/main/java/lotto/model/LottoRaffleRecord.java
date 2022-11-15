package lotto.model;

import lotto.config.LottoPrizeRules;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoRaffleRecord {

    private final Map<LottoPrizeRules, Integer> prizeRecord;
    private Long winningMoney = 0L;

    public LottoRaffleRecord() {
        prizeRecord = new LinkedHashMap<>();
        initByLottoPrizeRules();
    }

    private void initByLottoPrizeRules() {
        Arrays.stream(LottoPrizeRules.values()).forEach(this::initRecord);
    }

    private void initRecord(LottoPrizeRules prize) {
        prizeRecord.put(prize, 0);
    }

    public void updatePrizeRecord(LottoPrizeRules prize) {
        prizeRecord.put(prize, prizeRecord.get(prize) + 1);
    }

    public Map<LottoPrizeRules, Integer> getPrizeRecord() {
        return prizeRecord;
    }

    public Long getWinningMoney() {
        collectWinningMoney();
        return winningMoney;
    }

    private void collectWinningMoney() {
        prizeRecord.forEach((prize, count) -> winningMoney += prize.getWinningMoney() * count);
    }

}
