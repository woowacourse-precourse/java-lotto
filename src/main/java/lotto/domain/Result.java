package lotto.domain;

import java.util.Objects;

public class Result {
    int matchCount;
    boolean matchBonus;

    public Result(int matchCount, boolean matchBonus) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }
}
