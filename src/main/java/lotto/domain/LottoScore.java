package lotto.domain;

import lotto.constant.Score;

import java.util.HashMap;
import java.util.Map;

import static lotto.constant.Score.*;

public class LottoScore {

    private static final Map<Score, Integer> scoreStore = new HashMap<>();

    public static Map<Score, Integer> setInitialSetting() {
        scoreStore.put(THREE, 0);
        scoreStore.put(FOUR, 0);
        scoreStore.put(FIVE, 0);
        scoreStore.put(FIVE_BONUS, 0);
        scoreStore.put(SIX, 0);
        return scoreStore;
    }
}
