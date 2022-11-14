package lotto;

public enum Rank {
    RANK_1(6,2_000_000_000,"6개 일치 (2,000,000,000원)"),
    RANK_2(5,30_000_000,"5개 일치, 보너스 볼 일치 (30,000,000원)"),
    RANK_3(5,1_500_000,"5개 일치 (1,500,000원)"),
    RANK_4(4,50_000,"4개 일치 (50,000원)"),
    RANK_5(3,5_000,"3개 일치 (5,000원)"),
    RANK_NONE(0,0,"3개 미만 일치");

    private final int containCount;
    private final int reward;
    private final String notification;

    Rank(int containCount, int reward, String notification) {
        this.containCount = containCount;
        this.reward = reward;
        this.notification = notification;
    }

    public int getContainCount() {
        return containCount;
    }

    public int getReward() {
        return reward;
    }

    public String getNotification() {
        return notification;
    }
}
