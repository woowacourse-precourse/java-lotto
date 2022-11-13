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

    public void add(String place, int i) {
        lottoResults.put(place, lottoResults.get(place) + i);
    }

    public int getLottoPrizeCount(String place) {
        return lottoResults.get(place);
    }

    public void addLottoCount(int lottoCount, boolean isBonus) {
        if (lottoCount == 3) {
            add("FIFTH_PLACE", 1);
        } else if (lottoCount == 4) {
            add("FOURTH_PLACE", 1);
        } else if (lottoCount == 5 && !isBonus) {
            add("THIRD_PLACE", 1);
        } else if (lottoCount == 5 && isBonus) {
            add("SECOND_PLACE", 1);
        } else if (lottoCount == 6) {
            add("FIRST_PLACE", 1);
        }
    }
}
