package lotto.status;

public enum WinningStatus {
    FIRST(7, 6, 2000000000L),
    SECOND(6, 5, 30000000L),
    THIRD(5, 5, 1500000L),
    FOURTH(4, 4, 50000L),
    FIFTH(3, 3, 5000L);

    private final Integer luckyPoint;
    private final Integer numberMatchCount;
    private final Long reward;

    WinningStatus(Integer luckyPoint, Integer numberMatchCount, Long reward) {
        this.luckyPoint = luckyPoint;
        this.numberMatchCount = numberMatchCount;
        this.reward = reward;
    }

    public int getNumberMatchCount() {
        return numberMatchCount;
    }

    public long getReward() {
        return reward;
    }


    public static WinningStatus find(int luckyPoint) {
        if (luckyPoint == FIRST.luckyPoint) {
            return FIRST;
        }
        if (luckyPoint == SECOND.luckyPoint) {
            return SECOND;
        }
        if (luckyPoint == THIRD.luckyPoint) {
            return THIRD;
        }
        if (luckyPoint == FOURTH.luckyPoint) {
            return FOURTH;
        }
        return FIFTH;
    }
}
