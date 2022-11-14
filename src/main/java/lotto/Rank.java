package lotto;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    first(1, 2_000_000_000),
    second(2, 30_000_000),
    third(3, 1_500_000),
    fourth(4, 50_000),
    fifth(5, 5_000);

    private static final Map<Integer, Rank> BY_PLACE = new HashMap<>();

    static {
        for (Rank r : values()) {
            BY_PLACE.put(r.place, r);
        }
    }

    private final int place;
    private final int winningPrice;

    Rank(int place, int winningPrice) {
        this.place = place;
        this.winningPrice = winningPrice;
    }

    public int getWinningPrice() {
        return this.winningPrice;
    }

    public static Rank valueOfRank(int place) {
        return BY_PLACE.get(place);
    }
}
