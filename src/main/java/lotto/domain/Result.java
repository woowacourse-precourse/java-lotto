package lotto.domain;

public class Result {

    private int matchCount;
    private boolean isBonus;

    public void increaseMatchCount() {
        matchCount++;
    }

    public void matchBonus() {
        isBonus = true;
    }
}
