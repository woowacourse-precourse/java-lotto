package lotto.view;

import lotto.Ranking;

import java.util.Map;

public class OutputView {

  public static final String WINNING_RESULT_MESSAGE = "당첨 통계";
  public static final String DOTTED_LINE = "---";

  public static void printLottoAmount(int number) {
    System.out.println(number + "개를 구매했습니다.");
  }

  public static void printWinningStatistics(Map<Ranking, Integer> winningResult) {
    System.out.println(WINNING_RESULT_MESSAGE);
    System.out.println(DOTTED_LINE);
    System.out.println("3개 일치 (5,000원) - " + winningResult.get(Ranking.FIFTH) + "개");
    System.out.println("4개 일치 (50,000원) - " + winningResult.get(Ranking.FORTH) + "개");
    System.out.println("5개 일치 (1,500,000원) - " + winningResult.get(Ranking.THIRD) + "개");
    System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningResult.get(Ranking.SECOND) + "개");
    System.out.println("6개 일치 (2,000,000,000원) - " + winningResult.get(Ranking.FIRST) + "개");
  }

  public static void printTotalEarningsPercent(double earnings) {
    System.out.println("총 수익률은 " + earnings + "%입니다.");
  }
}
