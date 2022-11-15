package domain;

public enum LottoRank {
    MATCH_THREE("3개 일치", 5000, 0),
    MATCH_FOUR("4개 일치", 50000, 0),
    MATCH_FIVE("5개 일치", 1500000, 0),
    MATCH_FIVE_AND_BONUS("5개 일치, 보너스 볼 일치", 30000000, 0),
    MATCH_SIX("6개 일치", 2000000000, 0);


    private final String match;
    private final int reward;
    public int count;


    LottoRank(String match, int reward, int count) {
        this.match = match;
        this.reward = reward;
        this.count = count;
    }

    public String getInfo() {
        return this.match;
    }

    public int getReward() {
        return this.reward;
    }

    public void countRank() {
        this.count += 1;
    }
}