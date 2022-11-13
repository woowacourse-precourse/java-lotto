package lotto.domain;

public enum Rank {
    First("6개 일치", "2,000,000,000원"),
    Second("5개 일치, 보너스 볼 일치", "30,000,000원"),
    Third("5개 일치", " 1,500,000원"),
    Forth("4개 일치", "50,000원"),
    Fifth("3개 일치", "5,000원");

    private String condition;
    private String prize;

    Rank(String condition, String prize) {
        this.condition = condition;
        this.prize = prize;
    }

    public String getCondition() {
        return this.condition;
    }

    public String getPrize() {
        return this.prize;
    }
}
