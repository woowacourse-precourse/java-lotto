package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

/** Cli class to interact with user. */
public class Cli {

  /**
   * Function that receives user input to purchase lotto.
   * @return count of purchase.
   */
  public static int purchaseLotto() {
    System.out.println("구입금액을 입력해 주세요.");
    String amount = readLine();

    int purchaseCount = Integer.parseInt(amount) / 1000;

    System.out.printf("%d개를 구입했습니다.", purchaseCount);
    return purchaseCount;
  }
}
