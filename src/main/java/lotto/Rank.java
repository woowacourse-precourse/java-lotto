package lotto;

public enum Rank {
    FIRST(2000000000, 6, 0),
    SECOND(30000000, 5, 1),
    THIRD(1500000, 5, 0),
    FORTH(50000, 4, 0),
    FIFTH(5000, 3, 0);


    Rank(int reward, int basicMapNum, int bonusMapNum) {
        this.reward = reward;
        this.basicMapNum = basicMapNum;
        this.bonusMapNum = bonusMapNum;
    }
    private final int reward;
    private final int basicMapNum;
    private final int bonusMapNum;

    public int getReward() {
        return reward;
    }

    public int getBasicMapNum() {
        return basicMapNum;
    }

    public int getBonusMapNum() {
        return bonusMapNum;
    }
}
