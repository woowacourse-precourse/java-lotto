package lotto.domain.lotto;

public enum Rank {
    FIRST("1등", 2000000000), SECOND("2등", 30000000), THIRD("3등", 1500000), FOURTH("4등", 50000), FIFTH("5등", 5000), LOSE("미당첨", 0); // 1등, 2등, 3등, 4등, 5등, 미당청

    String name;
    long prize;

    Rank(String name, long prize) {
        this.name = name;
        this.prize = prize;
    }

    public long getPrize() {
        return prize;
    }
}
