package lotto.view;

import lotto.domain.Prize;

import java.util.ArrayList;
import java.util.Arrays;

public class WinningStatsView {

    public static final String WINNING_STATS_MESSAGE = "당첨 통계";
    public static final String CONTOUR = "---";
    public static final String WINNING_CONTOUR = " - ";
    public static final String WINNING_UNIT = "개";

    public static void showWinningStatsMessage() {
        System.out.println(WINNING_STATS_MESSAGE);
    }

    public static void showContour() {
        System.out.println(CONTOUR);
    }

    public static void showWinning(ArrayList<Integer> numberOfWinningTypes) {
        System.out.println(Prize.FIFTH_PLACE.getMessage() + WINNING_CONTOUR + numberOfWinningTypes.get(4) + WINNING_UNIT);
        System.out.println(Prize.FOURTH_PLACE.getMessage() + WINNING_CONTOUR + numberOfWinningTypes.get(3) + WINNING_UNIT);
        System.out.println(Prize.THIRD_PLACE.getMessage() + WINNING_CONTOUR + numberOfWinningTypes.get(2) + WINNING_UNIT);
        System.out.println(Prize.SECOND_PLACE.getMessage() + WINNING_CONTOUR + numberOfWinningTypes.get(1) + WINNING_UNIT);
        System.out.println(Prize.FIRST_PLACE.getMessage() + WINNING_CONTOUR + numberOfWinningTypes.get(0) + WINNING_UNIT);
    }
}
