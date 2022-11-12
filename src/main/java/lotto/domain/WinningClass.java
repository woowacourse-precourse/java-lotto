package lotto.domain;

public enum WinningClass {
    FIRST("6개 일치", 2000000000),
    SECOND("5개 일치, 보너스 볼 일치", 30000000),
    THIRD("5개 일치", 1500000),
    FOURTH("4개 일치", 50000),
    FIFTH("3개 일치", 5000);

    private final String condition;
    private final int prize;

    WinningClass(String condition, int prize) {
        this.condition = condition;
        this.prize = prize;
    }

    public String getCondition() {
        return condition;
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
