package lotto.service;

public enum WinningResult {
    MATCH_THREE("3개 일치", 5_000),
    MATCH_FOUR("4개 일치", 50_000),
    MATCH_FIVE("5개 일치", 1_500_000),
    MATCH_BONUS("5개 일치, 보너스 볼 일치", 30_000_000),
    MATCH_SIX("6개 일치", 2_000_000_000);

    private final String matching;
    private final int prize;

    WinningResult(String matching, int prize) {
        this.matching = matching;
        this.prize = prize;
    }

    public String getMatching() {
        return matching;
    }

    public int getPrize() {
        return prize;
    }
}
