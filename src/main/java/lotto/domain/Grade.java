package lotto.domain;

public enum Grade {
    FIRST("6개 일치", 6, 2000000000),
    SECOND("5개 일치, 보너스 볼 일치", 5,30000000),
    THIRD("5개 일치", 5,1500000),
    FOURTH("4개 일치", 4,50000),
    FIFTH("3개 일치", 3,5000);

    private final String condition;
    private final int matchCount;
    private final int prize;

    Grade(String condition, int matchCount, int prize) {
        this.condition = condition;
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public String getCondition() {
        return condition;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    @Override
    public String toString() {
        return "WinningClass{" +
                "condition='" + condition + '\'' +
                ", prize=" + prize +
                '}';
    }
}
