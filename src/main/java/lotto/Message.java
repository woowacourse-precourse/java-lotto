package lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class Message {
  public static void requestInputMoneyMessage() {
    System.out.println("구입금액을 입력해 주세요.");
  }

  public static void lottoBuyMessage(int count) {
    System.out.println(count + "개를 구매했습니다.");
  }

  public static void requestWinningNumberMessage() {
    System.out.println("당첨 번호를 입력해 주세요.");
  }

  public static void requestBonusNumberMessage() {
    System.out.println("보너스 번호를 입력해 주세요.");
  }

  public static void winningStatic() {
    System.out.println("당첨 통계");
  }

  public static void line() {
    System.out.println("---");
  }

  public static void prizeStatic(Map<Integer, Integer> maps) {
    Ranking[] values = Ranking.values();
    DecimalFormat decimalFormat = new DecimalFormat();
    for (Ranking value : values) {
      System.out.print(value.getRank() + "개 일치");
      if (value.getRank() == 7) {
        System.out.print(", 보너스 볼 일치");
      }
      System.out.println(" (" +
              decimalFormat.format(value.getMoney()) + "원) - " +
              maps.getOrDefault(value.getRank(), 0) + "개");
    }
  }
}
