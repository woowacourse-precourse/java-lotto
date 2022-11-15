package lotto.domain;


import java.util.List;

public enum Rank {
    THREE(3, 5000, "3개 일치 (5,000원)", 0),
    FOUR(4, 50_000, "4개 일치 (50,000원)", 1),
    FIVE(5, 1_500_000, "5개 일치 (1,500,000원)", 2),
    FIVEBONUS(5, 3_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)", 3),
    SIZ(6, 2_000_000_000, "6개 일치 (2,000,000,000원)", 4);

    private final int rightNumber;
    private final int prize;
    private final String message;
    private final int index;

    Rank(int rightNumber, int prize, String message, int index) {
        this.rightNumber = rightNumber;
        this.prize = prize;
        this.message = message;
        this.index = index;
    }

    public int getRightNumber() {
        return rightNumber;
    }

    public int getPrize() {
        return prize;
    }

    public int getIndex() {
        return index;
    }

    public String getMessage() {
        return message;
    }

    public static Rank valueOf(int index) {
        for (Rank rank : Rank.values()) {
            if (rank.index == index) {
                return rank;
            }
        }
        return null;
    }
}
