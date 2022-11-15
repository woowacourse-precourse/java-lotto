package lotto.model;

import java.text.NumberFormat;
import java.util.Arrays;

public enum Rank {
    OTHER(0, 0),
    FIFTH(5000, 3),
    FOURTH(50000, 4),
    THIRD(1500000, 5),
    SECOND(30000000, 5),
    FIRST(2000000000, 6);
    private final int prize;

    private final int same;

    Rank(int prize, int same) {
        this.prize = prize;
        this.same = same;
    }

    private String prizeString() {
        return NumberFormat.getInstance().format(prize);
    }

    @Override
    public String toString() {
        if (this == Rank.SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - ", same, prizeString());
        }
        return String.format("%d개 일치 (%s원) - ", same, prizeString());
    }

    public int getPrize() {
        return prize;
    }

    public static Rank ranking(int count) {
        return Arrays.stream(values())
            .filter(rank -> rank.same == count)
            .findFirst().orElse(OTHER);
    }

}
