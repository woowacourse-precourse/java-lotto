package lotto;

public enum Win {

    MATCH3("3개 일치 (5,000원)", 5000),
    MATCH4("4개 일치 (50,000원)", 50000),
    MATCH5("5개 일치 (1,500,000원)", 1500000),
    MATCH5BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    MATCH6("6개 일치 (2,000,000,000원)", 2000000000),
    EMPTY("없음", 0);

    private String title;
    private int reward;

    Win(String title, int reward) {
        this.title = title;
        this.reward = reward;
    }

    public String getTitle() {
        return title;
    }

    public int getReward() {
        return reward;
    }
}
