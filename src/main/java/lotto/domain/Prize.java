package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public enum Prize {
    FAIL(0, false, ""),
    FIFTH(3, false, "5,000"),
    FORTH(4, false, "50,000"),
    THIRD(5, false, "1,500,000"),
    SECOND(5, true, "30,000,000"),
    FIRST(6, false, "2,000,000,000");

    private final String reward;
    private final int binggoCnt;
    private final boolean applyBounus;

    private Prize(int binggoCnt, boolean applyBounus, String reward) {
        this.binggoCnt = binggoCnt;
        this.reward = reward;
        this.applyBounus = applyBounus;
    }

    public static Prize getMatchPrize(int binggoCnt, boolean isApplyBounus) {
        if (SECOND.isMatch(binggoCnt) || THIRD.isMatch(binggoCnt)) {
            return determineSecondOrThird(isApplyBounus);
        }
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.isMatch(binggoCnt))
                .findAny()
                .orElse(FAIL);
    }

    private boolean isMatch(int binggoCnt) {
        return this.binggoCnt == binggoCnt;
    }

    private static Prize determineSecondOrThird(boolean isApplyBounus) {
        if (isApplyBounus) {
            return SECOND;
        }
        return THIRD;
    }


    public String reward() {
        return this.reward;
    }

    public int binggoCnt() {
        return this.binggoCnt;
    }

    public boolean isApplyBounus() {
        return this.applyBounus;
    }

    public static Map<Prize, Integer> initializeMap() {
        Map<Prize, Integer> prizeMap = new EnumMap<>(Prize.class);
        prizeMap.put(Prize.FAIL, 0);
        prizeMap.put(Prize.FIFTH, 0);
        prizeMap.put(Prize.FORTH, 0);
        prizeMap.put(Prize.THIRD, 0);
        prizeMap.put(Prize.SECOND, 0);
        prizeMap.put(Prize.FIRST, 0);
        return prizeMap;
    }

}
