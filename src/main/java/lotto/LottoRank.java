package lotto;


public enum LottoRank {

    ZERO("0", 0,0),
    THREE("3개 일치 (5,000원)", 5000,0),
    FOUR("4개 일치 (50,000원)", 50000,0),
    FIVE("5개 일치 (1,500,000원)", 1500000, 0),
    FIVE_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000, 0),
    SIX("6개 일치 (2,000,000,000원)", 2000000000, 0);


    private final String message;

    private final double reward;
    private  int cnt;


    LottoRank(String message, double reward, int cnt) {
        this.message = message;
        this.reward = reward;
        this.cnt = cnt;
    }

    public String getMessage() {
        return message;
    }

    public int getCnt() {
        return cnt;
    }

    public double getReward() {
        return reward;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

}
