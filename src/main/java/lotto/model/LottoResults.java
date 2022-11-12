package lotto.model;

import java.util.HashMap;

public class LottoResults {
    HashMap<String, Integer> lottoResults = new HashMap<>();

    public LottoResults() {
        lottoResults.put("FIRST_PLACE", 0);
        lottoResults.put("SECOND_PLACE", 0);
        lottoResults.put("THIRD_PLACE", 0);
        lottoResults.put("FOURTH_PLACE", 0);
        lottoResults.put("FIFTH_PLACE", 0);
    }

    public HashMap<String, Integer> getLottoResults() {
        return lottoResults;
    }

    public void add(String place, int i) {
        lottoResults.put(place, lottoResults.get(place) + i);
    }

    public int getLottoPrizeCount(String place) {
        return lottoResults.get(place);
    }
}
