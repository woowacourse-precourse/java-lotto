package lotto;

public enum Lanking {
    rank1(2000000000),
    rank2(30000000),
    rank3(1500000),
    rank4(50000),
    rank5(5000);

    final private Integer reward;

    public Integer getReward() {
        return reward;
    }

    private Lanking(Integer reward) {
        this.reward = reward;
    }
}
