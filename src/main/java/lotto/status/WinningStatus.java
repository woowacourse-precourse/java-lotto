package lotto.status;

public enum WinningStatus {
    FIRST( 7,6, 2000000000L),
    SECOND( 6, 5,30000000L),
    THIRD( 5, 5,1500000L),
    FOURTH( 4, 4,50000L),
    FIFTH( 3, 3,5000L);

    private final Integer luckyOrder;
    private final Integer numberMatchCount;
    private final Long reward;

    WinningStatus(Integer luckyOrder, Integer numberMatchCount, Long reward) {
        this.luckyOrder = luckyOrder;
        this.numberMatchCount = numberMatchCount;
        this.reward = reward;
    }

    public int getNumberMatchCount() {
        return numberMatchCount;
    }

    public long getReward() {
        return reward;
    }


    public static WinningStatus find(int luckyOrder) {
        if (luckyOrder == FIRST.luckyOrder) {
            return FIRST;
        }
        if (luckyOrder == SECOND.luckyOrder) {
            return SECOND;
        }
        if (luckyOrder == THIRD.luckyOrder) {
            return THIRD;
        }
        if (luckyOrder == FOURTH.luckyOrder) {
            return FOURTH;
        }
        return FIFTH;
    }
}
