package lotto;

import lotto.config.LottoRules;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoRaffleRecord {

    private final Map<String, Integer> prizeRecord;

    public LottoRaffleRecord() {
        prizeRecord = new LinkedHashMap<>();
        initPrizeRecordByLottoRules();
    }

    private void initPrizeRecordByLottoRules() {
        Arrays.stream(LottoRules.values()).forEach(value -> prizeRecord.put(value.name(), 0));
    }

    public void updatePrizeRecord(String key) {
        prizeRecord.put(key, prizeRecord.get(key) + 1);
    }

    public Map<String, Integer> getPrizeRecord() {
        return prizeRecord;
    }
}
