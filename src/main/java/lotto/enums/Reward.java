package lotto.enums;

public enum Reward {
    THREE("3개 일치 (5,000원) - %d개%n", 5_000),
    FOUR("4개 일치 (50,000원) - %d개%n", 50_000),
    FIVE("5개 일치 (1,500,000원) - %d개%n", 1_500_000),
    FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", 30_000_000),
    SIX("6개 일치 (2,000,000,000원) - %d개%n", 2_000_000_000);


    private String reward;
    private Integer value;
    Reward(String reward, Integer value) {
        this.reward = reward;
        this.value = value;
    }
    public String getReward(){
        return reward;
    }
    public Integer getValue(){
        return value;
    }
}
