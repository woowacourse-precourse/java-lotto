package lotto.model;

public enum ResultEnum {
    //HIT_NONE(0, false, 0),
    HIT_3(3, false, 5000),
    HIT_4(4, false, 50000),
    HIT_5(5, false, 1500000),
    HIT_5_AND_BONUS(5, true, 30000000),
    HIT_6(6, false, 2000000000);

    private final Integer hitAmount;
    private final Boolean isBonusHit;
    private final Integer rewardAmount;

    ResultEnum(Integer hitAmount, boolean isBonusHit, Integer rewardAmount) {
        this.hitAmount = hitAmount;
        this.isBonusHit = isBonusHit;
        this.rewardAmount = rewardAmount;
    }

    public Integer getHitAmount() {
        return hitAmount;
    }

    public Boolean getIsBonusHit() {
        return isBonusHit;
    }

    public Integer getRewardAmount() {
        return rewardAmount;
    }
}
