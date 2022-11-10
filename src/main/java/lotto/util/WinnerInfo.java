package lotto.util;

public enum WinnerInfo {

    RANK1("6개 일치", "2,000,000,000원"),
    RANK2("5개 일치, 보너스 볼 일치", "30,000,000원"),
    RANK3("5개 일치", "1,500,000원"),
    RANK4("4개 일치", "50,000원"),
    RANK5("3개 일치", "5, 000원");

    private final String winningCondition;
    private final String prize;

    WinnerInfo(String winningCondition, String prize) {
        this.winningCondition = winningCondition;
        this.prize = prize;
    }

    public String getWinningCondition() {
        return this.winningCondition;
    }

    public String getPrizeInformation() {
        return this.prize;
    }

}
