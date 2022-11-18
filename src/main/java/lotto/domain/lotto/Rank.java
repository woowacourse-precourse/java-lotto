package lotto.domain.lotto;

public enum Rank {
    FIRST("6개 일치", 2000000000), SECOND("5개 일치, 보너스 볼 일치", 30000000), THIRD("5개 일치", 1500000), FOURTH("4개 일치", 50000), FIFTH("3개 일치", 5000), LOSE("미당첨", 0); // 1등, 2등, 3등, 4등, 5등, 미당청

    String name;
    long prize;

    Rank(String name, long prize) {
        this.name = name;
        this.prize = prize;
    }

    public String getName() {
        return name;
    }

    public long getPrize() {
        return prize;
    }
}
