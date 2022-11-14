package lotto;

import java.text.NumberFormat;
import java.util.Optional;

public enum Rank {
    FIFTH(5_000, "3개 일치"),
    FOURTH(50_000, "4개 일치"),
    THIRD(1_500_000, "5개 일치"),
    SECONDS(30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(2_000_000_000, "6개 일치");

    private final int prize;
    private final String condition;

    Rank(int prize, String condition) {
        this.prize = prize;
        this.condition = condition;
    }

    public static Optional<Rank> getRank(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {
            return Optional.of(FIRST);
        }
        if (matchCount == 5 && matchBonus) {
            return Optional.of(SECONDS);
        }
        if (matchCount == 5) {
            return Optional.of(THIRD);
        }
        if (matchCount == 4) {
            return Optional.of(FOURTH);
        }
        if (matchCount == 3) {
            return Optional.of(FIFTH);
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        return condition + " (" + numberFormat.format(prize) + "원)";
    }

    public int getPrize() {
        return prize;
    }

    public static void main(String[] args) {
        System.out.println(Rank.FOURTH);
    }
}
