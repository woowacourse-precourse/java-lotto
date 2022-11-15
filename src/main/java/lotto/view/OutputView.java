package lotto.view;

import lotto.Ranking;
import java.text.DecimalFormat;
import java.util.Map;


public class OutputView {

  public static final String WINNING_RESULT_MESSAGE = "당첨 통계";
  public static final String DOTTED_LINE = "---";
  public static final String BUY_LOTTO_MESSAGE = "%d개를 구매했습니다.";
  public static final String EQUAL_NUMBER_MESSAGE = "%d개 일치 (%s원) - %d개";
  public static final String EQUAL_NUMBER_FIVE_HAVE_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";

  public static void printLottoAmount(int number) {
    System.out.printf(BUY_LOTTO_MESSAGE, number);
    System.out.println();
  }

  public static void printWinningStatistics(Map<Ranking, Integer> winningResult) {
    System.out.println(WINNING_RESULT_MESSAGE);
    System.out.println(DOTTED_LINE);

    for (Map.Entry<Ranking, Integer> entry : winningResult.entrySet()) {

      if (entry.getKey().getNumber() == 5 && entry.getKey().isHasBonus()) {
        System.out.printf(EQUAL_NUMBER_FIVE_HAVE_BONUS_MESSAGE, entry.getKey().getNumber(), makePriceToString(entry.getKey().getMoney()), entry.getValue());
        System.out.println();
      }

      else if (entry.getKey().getNumber() == 5) {
        System.out.printf(EQUAL_NUMBER_MESSAGE, entry.getKey().getNumber(), makePriceToString(entry.getKey().getMoney()), entry.getValue());
        System.out.println();
      }

      else {
        System.out.printf(EQUAL_NUMBER_MESSAGE, entry.getKey().getNumber(), makePriceToString(entry.getKey().getMoney()), entry.getValue());
        System.out.println();
      }
    }
  }

  public static String makePriceToString(int price) {
    DecimalFormat decFormat = new DecimalFormat("###,###");
    return decFormat.format(price);
  }

  public static void printTotalEarningsPercent(double earnings) {
    System.out.println("총 수익률은 " + earnings + "%입니다.");
  }
}
