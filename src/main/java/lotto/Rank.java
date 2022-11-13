package lotto;

public enum Rank {
    FIRST(6,2000000000, "2,000,000,000원"),
    SECOND(5, 30000000, "30,000,000,000원"),
    THIRD(5, 1500000, "1,500,000원"),
    FOURTH(4, 50000, "50,000원"),
    FIFTH(3, 5000, "5,000원");

    private int hitCount;
    private int rewardInt;
    private String rewardString;

    Rank(int hitCount, int rewardInt, String rewardString) {
        this.hitCount = hitCount;
        this.rewardInt = rewardInt;
        this.rewardString = rewardString;
    }

    public int getHitCount() {
        return hitCount;
    }

    public int getRewardInt() {
        return rewardInt;
    }

    public String getRewardString() {
        return rewardString;
    }
}
