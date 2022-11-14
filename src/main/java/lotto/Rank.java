package lotto;

public enum Rank {
    FIFTH( 3, false, 5_000, "3개 일치 (5,000원) - %d개"),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원) - %d개"),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원) - %d개"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개");

    private final int match;
    private final boolean bonus;
    private final int prize;
    private final String text;

    Rank(int match, boolean bonus, int prize, String text) {
        this.match = match;
        this.bonus = bonus;
        this.prize = prize;
        this.text = text;
    }

    public boolean hasSameRank(int match, boolean bonus) {
        return this.match == match && this.bonus == bonus;
    }

    public String getText() {
        return text;
    }

    public int getPrize() {
        return prize;
    }
}