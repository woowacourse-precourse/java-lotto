package lotto;

/* 등수에 관한 Enum 입니다 */

public enum Rank {
    FIFTH(5_000, new Match(3)),
    FOURTH(50_000, new Match(4)),
    THIRD(1_500_000, new Match(5)),
    SECOND(30_000_000, new Match(5)),
    FIRST(2_000_000_000, new Match(6)),
    LAST(0, new Match(Match.NOTHING));

    private final int prize;
    private final Match match;


    private Rank(int prize, Match match) {
        this.prize = prize;
        this.match = match;
    }

    public static Rank getMyRank(Match match, boolean bonus) {
        if (match.getMatch() == Rank.THIRD.getMatch()) {
            if (bonus) {
                return Rank.SECOND;
            }
            return Rank.THIRD;
        }

        for (Rank rank : Rank.values()) {
            if (rank.getMatch() == match.getMatch()) {
                return rank;
            }
        }

        return Rank.LAST;
    }

    public int getPrize() {
        return this.prize;
    }

    private int getMatch() {
        return this.match.getMatch();
    }
}