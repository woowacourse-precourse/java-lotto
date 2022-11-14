package lotto.view;

public class WinningStatsView {

    public static final String WINNING_STATS_MESSAGE = "당첨 통계";
    public static final String CONTOUR = "---";

    public static void showWinningStatsMessage() {
        System.out.println(WINNING_STATS_MESSAGE);
    }

    public static void showContour() {
        System.out.println(CONTOUR);
    }
}
