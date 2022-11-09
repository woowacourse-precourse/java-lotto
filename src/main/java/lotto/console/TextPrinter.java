package lotto.console;

import java.util.HashMap;
import java.util.List;
import lotto.Lotto;
import lotto.tool.LottoTool;
import lotto.tool.Prize;

public class TextPrinter {

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

  public static void printResult(HashMap<Prize, Integer> result) {
    System.out.println("당첨 통계");
    System.out.println("---");
    for (Prize i : result.keySet()) {
      printReturnRate(i, result.get(i));
    }
    printReturnRate(LottoTool.calcReturnRate(result));
  }

  private static void printReturnRate(Prize prize, int num) {
    System.out.println(prize.getMatch() + "개 일치");
    if (prize.isIncludeBonnus()) {
      System.out.print(", 보너스 볼 일치");
    }
    System.out.println(" (" + prize.getPrizeMoney() + "원) - " + num + "개");
  }

  private static void printReturnRate(float rate) {
    System.out.println("총 수익률은 " + rate + "%입니다.");
  }

  public static void printErrorMessage(Exception e) {
    System.out.println("[ERROR] " + e.getMessage());
  }


}
