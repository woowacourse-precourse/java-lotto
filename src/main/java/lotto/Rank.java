package lotto;

public enum Rank {
    FIRST_PRIZE(2_000_000_000L, "6개 일치 (2,000,000,000원) - "),
    SECOND_PRIZE(30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD_PRIZE(1_500_000L, "5개 일치 (1,500,000원) - "),
    FOURTH_PRIZE(50_000L, "4개 일치 (50,000원) - "),
    FIFTH_PRIZE(5_000L, "3개 일치 (5,000원) - ");

    private final long amount;
    private final String resultMessage;

    Rank(long amount, String resultMessage) {
        this.amount = amount;
        this.resultMessage = resultMessage;
    }

    public long getAmount() {
        return amount;
    }

    public String getResultMessage() {
        return resultMessage;
    }

}
