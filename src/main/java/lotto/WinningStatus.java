package lotto;

public enum WinningStatus {
    FIRST(2_000_000_000, "2,000,000,000원"),
    SECOND(30_000_000, "30,000,000원"),
    THIRD(1_500_000, "1,500,000원"),
    FOURTH(50_000, "50,000원"),
    FIFTH(5_000, "5,000원");

    private int winningIntegerValue;
    private String winningStringValue;

    WinningStatus(int winningIntegerValue, String winningStringValue) {
        this.winningIntegerValue = winningIntegerValue;
        this.winningStringValue = winningStringValue;
    }

    public int getWinningIntegerValue() {
        return winningIntegerValue;
    }

    public String getWinningStringValue() {
        return winningStringValue;
    }

    public static int[] getMoneyList() {
        int[] moneyList = {FIRST.getWinningIntegerValue(), SECOND.getWinningIntegerValue(), THIRD.getWinningIntegerValue(), FOURTH.getWinningIntegerValue(), FIFTH.getWinningIntegerValue()};
        return moneyList;
    }
}
