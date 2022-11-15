package lotto.utils;

public enum PrizeInfo {

    PRIZE1(1, "6개 일치 (2,000,000,000원) - ", 2000000000),
    PRIZE2(2, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    PRIZE3(3, "5개 일치 (1,500,000원) - ", 1500000),
    PRIZE4(4, "4개 일치 (50,000원) - ", 50000),
    PRIZE5(5, "3개 일치 (5,000원) - ", 5000);

    private final int rank;
    private final String outputMessage;
    private final int reward;

    PrizeInfo(int rank, String outputMessage, int reward) {
        this.rank = rank;
        this.outputMessage = outputMessage;
        this.reward = reward;
    }

    public int getRank() {
        return rank;
    }

    public String getOutputMessage() {
        return outputMessage;
    }

    public int getReward() {
        return reward;
    }
}
