package lotto;

import java.util.Arrays;

public enum Rank {
    FAIL(new Result(0, false), 0),
    FIVE(new Result(3, false), 5_000),
    FOUR(new Result(4, false), 50_000),
    THREE(new Result(5, false), 1_500_000),
    TWO(new Result(5, true), 30_000_000),
    ONE(new Result(6, false), 2_000_000_000);

    private final Result result;
    private final int prize;

    Rank(final Result result, final int prize) {
        this.result = result;
        this.prize = prize;
    }

    public static Rank findByRank(final Result result) {
        return Arrays.stream(Rank.values())
                .filter(rank -> validate(rank, result))
                .findAny()
                .orElse(FAIL);
    }

    private static boolean validate(Rank rank, Result result) {
        if (result.equals(rank.result)) {
            return true;
        }
        return false;
    }

    public Result getResult() {
        return result;
    }

    public int getPrize() {
        return prize;
    }
}
