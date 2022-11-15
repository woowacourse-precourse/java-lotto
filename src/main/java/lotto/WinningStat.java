package lotto;

import lotto.constant.MatchingType;

public class WinningStat {

    private final MatchingType matchingType;
    private int count;

    public WinningStat(MatchingType matchingType, int count) {
        this.matchingType = matchingType;
        this.count = count;
    }

    public MatchingType getMatchingType() {
        return matchingType;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        this.count++;
    }
}
