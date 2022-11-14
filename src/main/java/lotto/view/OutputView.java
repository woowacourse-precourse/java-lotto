package lotto.view;

import lotto.Ranking;
import java.util.Map;


public class OutputView {

  public static void printWinningStatistics(Map<Ranking, Integer> winningResult) {
    System.out.println("3개 일치 (5,000원) - " + winningResult.get(Ranking.FIFTH) + "개");
    System.out.println("4개 일치 (50,000원) - " + winningResult.get(Ranking.FORTH) + "개");
    System.out.println("5개 일치 (1,500,000원) - " + winningResult.get(Ranking.THIRD) + "개");
    System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningResult.get(Ranking.SECOND) + "개");
    System.out.println("6개 일치 (2,000,000,000원) - " + winningResult.get(Ranking.FIRST) + "개");
  }
}
