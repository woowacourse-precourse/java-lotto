package lotto.Enums;

public enum Reward {

    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FORTH(50000),
    FIFTH(5000);

    private int reward;

    Reward(int reward) {this.reward = reward;}

    public int getReward() {return reward;}
}
