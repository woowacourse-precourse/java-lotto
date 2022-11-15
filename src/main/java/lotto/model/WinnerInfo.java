package lotto.model;

/*
 * 로또 당첨 조건 및 상금 등의 정보를 담당하는 enum 클래스
 */

public enum WinnerInfo {

    RANK1(1, 6, "6개 일치 (2,000,000,000원)", 2_000_000_000),
    RANK2(2, 5, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
    RANK3(3, 5, "5개 일치 (1,500,000원)", 1_500_000),
    RANK4(4, 4, "4개 일치 (50,000원)", 50_000),
    RANK5(5, 3, "3개 일치 (5,000원)", 5_000);

    private final int rank;
    private final int winningCondition;
    private final String winningMessage; // TODO: 출력 때문에 추가한 부분인데, View에서 자체적으로 해결할 수 있는 방법이 있을지?
    private final int prize;

    WinnerInfo(int rank, int winningCondition, String winningMessage, int prize) {
        this.rank = rank;
        this.winningCondition = winningCondition;
        this.winningMessage = winningMessage;
        this.prize = prize;
    }

    public int getRank() {
        return this.rank;
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

}
