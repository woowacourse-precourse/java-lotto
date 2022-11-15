package lotto;

import java.text.NumberFormat;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NOTHING(0, 0);

    private final int numberOfRight;
    private final int prizeMoney;

    private static int MINIMAL_RIGHT = 3;
    private Rank(int numberOfRight, int prizeMoney) {
        this.numberOfRight = numberOfRight;
        this.prizeMoney = prizeMoney;
    }

    public static Rank valueOf(int numberOfRight, boolean matchBonus){
        if(numberOfRight < MINIMAL_RIGHT) return NOTHING;

        if(SECOND.numberOfRight == numberOfRight && matchBonus) return SECOND;

        for (Rank rank : values()) {
            if (rank.numberOfRight == numberOfRight && rank != SECOND) return rank;
        }

        throw new IllegalArgumentException(numberOfRight + "은 유효하지 않습니다.");
    }

    public int getNumberOfRight() {
        return numberOfRight;
    }

    public int getPrizeMoney(){
        return prizeMoney;
    }

    public String getFormatPrizeMoney() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        return numberFormat.format(getPrizeMoney());
    }
}
