package lotto.util;

public class Calculate {
    private Calculate() {
    }

    public static double getRatio(final long totalWinningPrice, final int buyingPrice) {
        return Math.round((double) totalWinningPrice / buyingPrice * 1000) / 10.0;

    }
}
