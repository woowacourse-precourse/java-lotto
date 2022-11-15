package lotto.util;

public enum Result {
    RANK_FIVE("3개 일치 (5,000원) - ", 5_000),
    RANK_FOUR("4개 일치 (50,000원) - ", 50_000),
    RANK_THREE("5개 일치 (1,500,000원) - ", 1_500_000),
    RANK_TWO("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30_000_000),
    RANK_ONE("6개 일치 (2,000,000,000원) - ", 2_000_000_000);

    private final String message;
    private final long reward ;

    Result(String message, long reward) {
        this.message = message;
        this.reward = reward ;
    }

    public String getMessage() {
        return this.message;
    }
    public long getReward(){
        return this.reward ;
    }
}
