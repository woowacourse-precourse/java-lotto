package lotto.model;

/*
 * 로또 당첨 조건 및 상금 등의 정보를 담당하는 enum 클래스
 */

public enum WinnerInfo {

    RANK1(6, "6개 일치 (2,000,000,000원)", 2_000_000_000),
    RANK2(5, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
    RANK3(5, "5개 일치 (1,500,000원)", 1_500_000),
    RANK4(4, "4개 일치 (50,000원)", 50_000),
    RANK5(3, "3개 일치 (5,000원)", 5_000);

    private static final int hasNoRankInfo = -1;

    private final int winningCondition;
    private final String winningMessage;
    private final int prize;

    WinnerInfo(int winningCondition, String winningMessage, int prize) {
        this.winningCondition = winningCondition;
        this.winningMessage = winningMessage;
        this.prize = prize;
    }

    public static int hasNoRank() {
        return hasNoRankInfo;
    }

    public int getWinningCondition() {
        return this.winningCondition;
    }

    public String getWinningMessage() {
        return this.winningMessage;
    }

    public int getPrizeInformation() {
        return this.prize;
    }

    public static int getRank(int matchedCount) {
        for (int i = 0; i < WinnerInfo.values().length; i++) {
            if (matchedCount == RANK2.winningCondition) {
                continue;
            }
            if (matchedCount == WinnerInfo.values()[i].winningCondition) {
                return WinnerInfo.values()[i].ordinal();
            }
        }
        return hasNoRankInfo;
    }

    public static int checkRank2(boolean winBonusNumber) {
        if (winBonusNumber) {
            return RANK2.ordinal();
        }
        return RANK3.ordinal();
    }

}
