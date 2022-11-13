package lotto;

import lotto.config.LottoRules;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoRaffleRecorder {

    private final Map<String, Integer> prizeRecord;

    public LottoRaffleRecorder() {
        prizeRecord = new LinkedHashMap<>();
        Arrays.stream(LottoRules.values()).forEach(value -> prizeRecord.put(value.name(), 0));
    }

    public void updatePrizeRecord(String key) {
        prizeRecord.put(key, prizeRecord.get(key) + 1);
    }

    public Map<String, Integer> getPrizeRecord(){
        return prizeRecord;
    }
}
