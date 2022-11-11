package lotto;

import java.util.List;

public class PrintOut {
  public static void requestInputMessage() {
    System.out.println("구입금액을 입력해 주세요.");
  }

  public static void lottoBuyMessage(int count) {
    System.out.println(count + "개를 구매했습니다.");
  }

  public static void requestWinningNumberMessage() {
    System.out.println("당첨 번호를 입력해 주세요.");
  }

  public static void requesBonusNumberMessage() {
    System.out.println("보너스 번호를 입력해 주세요.");
  }
}
