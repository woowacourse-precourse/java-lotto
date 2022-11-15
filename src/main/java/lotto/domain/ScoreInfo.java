package lotto.domain;

public enum ScoreInfo {
    THREE(5, 3, 0, 5000, "3개 일치 (5,000원) - "),
    FOUR(4, 4, 0, 50000, "4개 일치 (50,000원) - "),
    FIVE(3, 5, 0, 1500000, "5개 일치 (1,500,000원) - "),
    FIVE_ALPHA(2, 6, 1, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX(1, 6, 0, 2000000000, "6개 일치 (2,000,000,000원) - "),
    ELSE(0, 0, 0, 0, "");


    private final Integer rank;
    private final Integer correctCount;
    private final Integer correctBonusCount;
    private final Integer winnerMoney;
    private final String message;

    ScoreInfo(Integer rank, Integer correctCount, Integer correctBonusCount, Integer winnerMoney, String message) {
        this.rank = rank;
        this.correctCount = correctCount;
        this.correctBonusCount = correctBonusCount;
        this.winnerMoney = winnerMoney;
        this.message = message;
    }

    public Integer getRank() {
        return rank;
    }

    public Integer getWinnerMoney() {
        return winnerMoney;
    }

    public Integer getCorrectCount() {
        return correctCount;
    }

    public Integer getCorrectBonusCount() {
        return correctBonusCount;
    }

    public String getMessage() {
        return message;
    }


}
