package lotto;

public enum Prize {

    FIFTH(5000, "3개 일치 (5,000원) - "),
    FOURTH(50000, "4개 일치 (50,000원) - "),
    THRID(1500000,"5개 일치 (1,500,000원) - "),
    SECOND(30000000,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(2000000000,"6개 일치 (2,000,000,000원) - ");

    private int reward;
    private String message;

    Prize(int reward, String message) {
        this.reward = reward;
        this.message = message;
    }

    public int getReward() {
        return reward;
    }

    public String getMessage() {
        return message;
    }
}
