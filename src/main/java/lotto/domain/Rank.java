package lotto.domain;


import java.util.List;

public enum Rank {
    THREE(3,5000),
    FOUR(4,50_000),
    FIVE(5,1_500_000),
    FIVEBONUS(5,3_000_000),
    SIZ(6,2_000_000_000);

    private final int rightNumber;
    private final int prize;

    Rank(int rightNumber, int prize) {
        this.rightNumber = rightNumber;
        this.prize = prize;
    }

    public int getRightNumber() {
        return rightNumber;
    }

    public int getPrice() {
        return prize;
    }

    public Rank valueOf(int rightNumber, boolean bonusBall) {
        if (rightNumber == Rank.FIVEBONUS.rightNumber || bonusBall == true) {
            return Rank.FIVEBONUS;
        }

        for (Rank rank : Rank.values()) {
            if (rank.rightNumber == rightNumber) {
                return rank;
            }
        }

        return null;
    }
}
