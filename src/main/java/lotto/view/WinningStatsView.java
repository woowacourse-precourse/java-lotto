package lotto.view;

import lotto.domain.Prize;

import java.util.ArrayList;
import java.util.Arrays;

public class WinningStatsView {

    public static final String WINNING_STATS_MESSAGE = "당첨 통계";
    public static final String CONTOUR = "---";
    public static final String WINNING_CONTOUR = " - ";
    public static final String WINNING_UNIT = "개";
    public static final String RATE_OF_RETURN_FRONT_MESSAGE = "총 수익률은 ";
    public static final String RATE_OF_RETURN_BACK_MESSAGE = "%입니다.";
    public static final String LINE_BREAK = "\r";

    public void showWinningStatsMessage() {
        System.out.println(WINNING_STATS_MESSAGE);
    }

    public void showContour() {
        System.out.println(CONTOUR);
    }

    public void showWinning(ArrayList<Integer> numberOfWinningTypes) {
        System.out.println(Prize.FIFTH_PLACE.getMessage() + WINNING_CONTOUR + numberOfWinningTypes.get(4) + WINNING_UNIT);
        System.out.println(Prize.FOURTH_PLACE.getMessage() + WINNING_CONTOUR + numberOfWinningTypes.get(3) + WINNING_UNIT);
        System.out.println(Prize.THIRD_PLACE.getMessage() + WINNING_CONTOUR + numberOfWinningTypes.get(2) + WINNING_UNIT);
        System.out.println(Prize.SECOND_PLACE.getMessage() + WINNING_CONTOUR + numberOfWinningTypes.get(1) + WINNING_UNIT);
        System.out.println(Prize.FIRST_PLACE.getMessage() + WINNING_CONTOUR + numberOfWinningTypes.get(0) + WINNING_UNIT);
    }

    public void showRateOfReturn(String rateOfReturn) {
        System.out.println(RATE_OF_RETURN_FRONT_MESSAGE + rateOfReturn + RATE_OF_RETURN_BACK_MESSAGE);
    }

    public void showLineBreak() {
        System.out.println(LINE_BREAK);
    }
}
