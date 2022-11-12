package lotto.domain;

public enum LottoRank {
    FIRST("6개 일치", 1, 2000000000),
    SECOND("5개 일치, 보너스 볼 일치", 2, 30000000),
    THIRD("5개 일치", 3, 1500000),
    FOURTH("4개 일치", 4, 50000),
    FIFTH("3개 일치", 5, 5000),
    LOSE("꽝", 0, 0);

    private final String description;
    private final int rank;
    private final int prize;

    LottoRank(String description, int rank, int prize) {
        this.description = description;
        this.rank = rank;
        this.prize = prize;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPrize() {
        return this.prize;
    }

    public int getRank() {
        return this.rank;
    }
}
