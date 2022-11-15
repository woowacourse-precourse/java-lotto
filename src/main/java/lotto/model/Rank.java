package lotto.model;

import java.util.Arrays;

public enum Rank {
    FAIL(new Result(0, false), 0, ""),
    FIVE(new Result(3, false), 5_000, "3개 일치 (5,000원) - "),
    FOUR(new Result(4, false), 50_000, "4개 일치 (50,000원) - "),
    THREE(new Result(5, false), 1_500_000, "5개 일치 (1,500,000원) - "),
    TWO(new Result(5, true), 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    ONE(new Result(6, false), 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    private final Result result;
    private final int prize;
    private final String text;

    Rank(final Result result, final int prize, final String text) {
        this.result = result;
        this.prize = prize;
        this.text = text;
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

    public String getText() {
        return text;
    }
}
