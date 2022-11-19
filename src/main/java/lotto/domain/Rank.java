package lotto.domain;

public enum Rank {
    FIRST(6, 0, 2000000000, 4),
    SECOND(5, 1, 30000000, 3),
    THIRD(5, 0, 1500000, 2),
    FOURTH(4, 0, 50000, 1),
    FIFTH(3, 0, 5000, 0);

    private int predictionMatchCnt;
    private int bonusMatchCnt;
    private int prize;
    private int WinningLogIdx;

    Rank(int predictionMatchCnt, int bonusMatchCnt, int prize, int WinningLogIdx) {
        this.predictionMatchCnt = predictionMatchCnt;
        this.bonusMatchCnt = bonusMatchCnt;
        this.prize = prize;
        this.WinningLogIdx = WinningLogIdx;
    }

    public int getPredictionMatchCnt() {
        return predictionMatchCnt;
    }

    public int getBonusMatchCnt() {
        return bonusMatchCnt;
    }

    public int getPrize() {
        return prize;
    }

    public int getWinningLogIdx() {
        return WinningLogIdx;
    }
}

