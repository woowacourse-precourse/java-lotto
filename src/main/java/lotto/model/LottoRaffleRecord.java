package lotto.model;

import lotto.config.LottoPrize;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoRaffleRecord {

    private final Map<LottoPrize, Integer> prizeRecord;
    private Long winningMoney = 0L;

    public LottoRaffleRecord() {
        prizeRecord = new LinkedHashMap<>();
        initByLottoPrizeRules();
    }

    private void initByLottoPrizeRules() {
        Arrays.stream(LottoPrize.values()).forEach(this::initRecord);
    }

    private void initRecord(LottoPrize prize) {
        prizeRecord.put(prize, 0);
    }

    public void updatePrizeRecord(LottoPrize prize) {
        prizeRecord.put(prize, prizeRecord.get(prize) + 1);
    }

    public Map<LottoPrize, Integer> getPrizeRecord() {
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
