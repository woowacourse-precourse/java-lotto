package lotto.ENUMS;

public enum Rank {
    RANK1("6개 일치", "2,000,000,000원"),
    RANK2("5개 일치, 보너스 볼 일치", "30,000,000원"),
    RANK3("5개 일치", "1,500,000원"),
    RANK4("4개 일치", "50,000원"),
    RANK5("3개 일치", "5,000원");

    String condition;
    String winnings;

    Rank(String condition, String winnings) {
        this.condition = condition;
        this.winnings = winnings;
    }

    public String getCondition() {
        return condition;
    }

    public String getWinnings() {
        return winnings;
    }
}
