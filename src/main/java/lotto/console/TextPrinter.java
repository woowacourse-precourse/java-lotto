package lotto.console;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import lotto.Lotto;
import lotto.tool.Rank;

public class TextPrinter {

  private static final DecimalFormat formatter = new DecimalFormat("#,##0");

  public static void printGetPrice() {
    System.out.println("구입금액을 입력해 주세요.");
  }

  public static void printLotto(List<Lotto> lottoList) {
    System.out.println(lottoList.size() + "개를 구매했습니다.");
    for (int i = 0; i < lottoList.size(); i++) {
      System.out.println(lottoList.get(i));
    }
  }

  public static void printGetWinnerNumber() {
    System.out.println("당첨 번호를 입력해 주세요.");
  }

  public static void printGetBonnusNumber() {
    System.out.println("보너스 번호를 입력해 주세요.");
  }

  public static void printTotalResult(HashMap<Rank, Integer> result) {
    System.out.println("당첨 통계");
    System.out.println("---");
    for (Rank i : result.keySet()) {
      printRankResult(i, result.get(i));
    }
  }

  private static void printRankResult(Rank rank, int num) {

    System.out.print(rank.getMatch() + "개 일치");
    if (rank.isIncludeBonnus()) {
      System.out.print(", 보너스 볼 일치");
    }
    System.out.println(" (" + formatter.format(rank.getPrizeMoney()) + "원) - " + num + "개");
  }

  public static void printReturnRate(double rate) {
    System.out.println("총 수익률은 " + String.format("%.1f", rate) + "%입니다.");
  }

  public static void printErrorMessage(Exception e) {
    System.out.println("[ERROR] " + e.getMessage());
  }


}
