package lotto.constant;

public enum WinningResult {
    RANK_1("1등", 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    RANK_2("2등", 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    RANK_3("3등", 1_500_000, "5개 일치 (1,500,000원)"),
    RANK_4("4등", 50_000, "4개 일치 (50,000원)"),
    RANK_5("5등", 5_000, "3개 일치 (5,000원)"),
    RANK_NONE("꽝", 0, "3개 미만 일치 (0원)");

    private final String rank;
    private final long reward;
    private final String announcement;

    WinningResult(String rank, long reward, String announcement) {
        this.rank = rank;
        this.reward = reward;
        this.announcement = announcement;
    }

    public long getReward() {
        return reward;
    }

    public String getAnnouncement() {
        return announcement;
    }
}
