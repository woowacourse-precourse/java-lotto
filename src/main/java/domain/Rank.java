package domain;

public enum Rank {
    FIRST("6개 일치 ", 2_000_000_000),
    SECOND("5개 일치, 보너스 볼 일치 ", 30_000_000),
    THIRD("5개 일치 ", 1_500_000),
    FOURTH("4개 일치 ", 50_000),
    FIFTH("3개 일치 ", 5000);

    private final String result;
    private final int reward;

    Rank(String result, int reward) {
        this.result = result;
        this.reward = reward;
    }

    public String getValue() {
        return result;
    }

    public int getReward(){return reward;}
}
