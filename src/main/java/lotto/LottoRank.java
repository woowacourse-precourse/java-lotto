package lotto;

public enum LottoRank {
    FIFTH_PLACE("3개 일치", "(5,000원)"),
    FOURTH_PLACE("4개 일치", "(50,000원)"),
    THIRD_PLACE("5개 일치", "(1,500,000원)"),
    SECOND_PLACE("5개 일치,", "보너스 볼 일치 (30,000,000원)"),
    FIRST_PLACE("6개 일치", "(2,000,000,000원)");

    private final String winningCount;
    private final String winningPrice;

    LottoRank(String winningCount, String winningPrice) {
        this.winningCount = winningCount;
        this.winningPrice = winningPrice;
    }

    public String getWinningCount() {
        return winningCount;
    }

    public String getWinningPrice() {
        return winningPrice;
    }
}
