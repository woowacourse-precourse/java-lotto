package lotto;

public enum ResultEnum {
    HIT_NONE(0, 0),
    HIT_3(3, 5000),
    HIT_4(4, 50000),
    HIT_5(5, 1500000),
    HIT_5_AND_BONUS(5, 30000000),
    HIT_6(6, 2000000000);

    private final Integer hitAmount;
    private final Integer rewardAmount;

    ResultEnum(Integer hitAmount, Integer rewardAmount) {
        this.hitAmount = hitAmount;
        this.rewardAmount = rewardAmount;
    }

    public Integer getHitAmount() {
        return hitAmount;
    }

    public Integer getRewardAmount() {
        return rewardAmount;
    }
}
