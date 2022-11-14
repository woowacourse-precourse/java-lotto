package lotto.model;

import lotto.utils.LottoRanking;

import java.util.Arrays;
import java.util.HashMap;

public class LottoResults {
    private static final int START_COUNT = 0;
    HashMap<String, Integer> lottoResults = new HashMap<>();

    public LottoResults() {
        Arrays.stream(LottoRanking.values())
                .forEach(prize -> lottoResults.put(prize.toString(), START_COUNT));
    }

    public void add(String place, int i) {
        lottoResults.put(place, lottoResults.get(place) + i);
    }

    public int getLottoPrizeCount(String place) {
        return lottoResults.get(place);
    }

    public void addLottoCount(int lottoCount, boolean isBonus) {
        for (LottoRanking rank : LottoRanking.values()) {
            if (lottoCount == rank.getMatchCount() && isBonus == rank.getBonus()) {
                add(rank.toString(), 1);
            }
        }
    }
}
