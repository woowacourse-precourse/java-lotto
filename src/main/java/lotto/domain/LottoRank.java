package lotto.domain;

public enum LottoRank {
    FIRST("6개 일치", 2000000000),
    SECOND("5개 일치, 보너스 볼 일치", 30000000),
    THIRD("5개 일치", 1500000),
    FORTH("4개 일치", 50000),
    FIFTH("3개 일치", 5000),
    NOTHING("2개 이하 일치", 0);

    private String condition;
    private int prize;

    LottoRank(String condition, int prize) {
        this.condition = condition;
        this.prize = prize;
    }

    public String getCondition() {
        return this.condition;
    }

    public int getPrize() {
        return this.prize;
    }
}
