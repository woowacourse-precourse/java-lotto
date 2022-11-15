package service;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Winner {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(-1, 30_000_000),
    THIRD_PLACE(5, 1_5000_000),
    FOURTH_PLACE(4, 50_000),
    FIFTH_PLACE(3, 5_000),
    LAST_PLACE(2, 0);

    private final int match;
    private final int prize;

    Winner(int match, int prize) {
        this.match = match;
        this.prize = prize;
    }

    public int getMatch() {
        return this.match;
    }

    public int getPrize() {
        return this.prize;
    }

    private static final Map<Integer, Winner> BY_MATCH =
            Stream.of(values()).collect(Collectors.toMap(Winner::getMatch, Function.identity()));

    public static Winner getByMatch(int match) {
        if (match <= LAST_PLACE.getMatch()) {
            return Winner.LAST_PLACE;
        }
        return BY_MATCH.get(match);
    }
}
