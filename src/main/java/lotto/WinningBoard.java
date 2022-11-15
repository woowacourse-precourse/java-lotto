package lotto;

public enum WinningBoard {
    FIRST(6, 2000000000),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);


    private final int hitCount;

    private final int reward;

    private boolean hitBonus = false;

    WinningBoard(int hitCount, int reward) {
        this.hitCount = hitCount;
        this.reward = reward;
    }

    WinningBoard(int hitCount, int reward, boolean hitBonus) {
        this.hitCount = hitCount;
        this.reward = reward;
        this.hitBonus = hitBonus;
    }

    public int getHitCount() {
        return hitCount;
    }

    public int getReward() {
        return reward;
    }

    public boolean getHitBonus() {
        return hitBonus;
    }
}
