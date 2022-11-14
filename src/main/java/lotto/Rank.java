package lotto;

public enum Rank {
    FIRST(2000000000, 6, 0,0),
    SECOND(30000000, 5, 1,0),
    THIRD(1500000, 5, 0,0),
    FORTH(50000, 4, 0,0),
    FIFTH(5000, 3, 0,0);


    Rank(int reward, int basicMapNum, int bonusMapNum, int count) {
        this.reward = reward;
        this.basicMapNum = basicMapNum;
        this.bonusMapNum = bonusMapNum;
        this.count = count;
    }
    private final int reward;
    private final int basicMapNum;
    private final int bonusMapNum;
    private int count;

    public int getReward() {
        return reward;
    }
    public int getBasicMapNum() {
        return basicMapNum;
    }
    public int getBonusMapNum() {
        return bonusMapNum;
    }
    public int getCount(){return count;}
    public void plusCount() {
        this.count++;
    }
}
