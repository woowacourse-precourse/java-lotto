package lotto;

public enum Rank {
    FIRST(6, 2000000000, 1),
    SECOND(5, 30000000, 2),
    THIRD(5, 1500000, 3),
    FOURTH(4, 50000, 4),
    FIFTH(3, 5000, 5),
    NONE(0, 0, 6);

    private int match;
    private int prize;
    private int place;

    Rank(int match, int prize, int place) {
        this.match = match;
        this.prize = prize;
        this.place = place;
    }

    public int getMatch() {
        return match;
    }

    public int getPrize() {
        return prize;
    }

    public int getPlace() {
        return place;
    }

    public static Rank getRank(int match, boolean bonusFlag) {
        if (match == 6) {
            return FIRST;
        }
        if (match == 5 && bonusFlag == true) {
            return SECOND;
        }
        if (match == 5) {
            return THIRD;
        }
        if (match == 4) {
            return FOURTH;
        }
        if (match == 3) {
            return FIFTH;
        }
        return NONE;
    }
}
