package YieldMachine;

public enum Reward {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    final private Integer price;
    public Integer getReward() {
        return price;
    }
    private Reward(Integer price) {
        this.price = price;
    }
}
