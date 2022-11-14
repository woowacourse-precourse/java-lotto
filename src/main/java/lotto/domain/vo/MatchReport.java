package lotto.domain.vo;

public class MatchReport {

    private int hitCount = 0;
    private boolean bonus = false;

    public MatchReport() {
    }

    public void countPlus() {
        hitCount += 1;
    }

    public void bonusTurnTrue() {
        bonus = true;
    }

    public int currentHitCount() {
        return hitCount;
    }

    public boolean currentBonus() {
        return bonus;
    }
}
