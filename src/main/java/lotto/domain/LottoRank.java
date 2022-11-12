package lotto.domain;

public enum LottoRank {
    FIRST("6개 일치", 2000000000),
    SECOND("5개 일치, 보너스 볼 일치", 30000000),
    THIRD("5개 일치", 1500000),
    FOURTH("4개 일치", 50000),
    FIFTH("3개 일치", 5000),
    LOSE("꽝", 0);

    private String description;
    private int prize;

    LottoRank(String description, int prize) {
        this.description = description;
        this.prize = prize;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPrize() {
        return this.prize;
    }
}
