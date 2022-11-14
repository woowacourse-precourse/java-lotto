package lotto.message;

import lotto.Ranking;

import java.util.Map;

public class Message {
  public static void requestInputMoneyMessage() {
    System.out.println("구입금액을 입력해 주세요.");
  }

  public static void lottoBuyMessage(long count) {
    System.out.println(count + "개를 구매했습니다.");
  }

  public static void requestWinningNumberMessage() {
    System.out.println("당첨 번호를 입력해 주세요.");
  }

  public static void requestBonusNumberMessage() {
    System.out.println("보너스 번호를 입력해 주세요.");
  }

  public static void winningStatics() {
    System.out.println("당첨 통계");
    System.out.println("---");
  }

  public static void matchMessage(Map<Integer, Integer> maps) {
    Message.winningStatics();
    Ranking[] values = Ranking.values();
    for (Ranking value : values) {
      System.out.print(value.getMessage());
      System.out.println(maps.getOrDefault(value.getRank(), 0) + "개");
    }
  }

  public static void ratio(String percentage) {
    System.out.println("총 수익률은 " + percentage + "%입니다.");
  }
}
