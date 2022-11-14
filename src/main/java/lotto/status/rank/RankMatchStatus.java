package lotto.status.rank;

public enum RankMatchStatus {
    rank1(6),
    rank2(5),
    rank3(5),
    rank4(4),
    rank5(3);

    private int match;

    RankMatchStatus(int match) {
        this.match = match;
    }

    public int getMatch() {
        return match;
    }
}
