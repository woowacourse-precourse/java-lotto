package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Validation.isNumeric;

/** Cli class to interact with user. */
public class Cli {

  /**
   * Function that receives user input to purchase lotto.
   * @return count of purchase.
   */
  public static int purchaseLotto() {
    System.out.println("구입금액을 입력해 주세요.");
    String amount = readLine();

    validate(amount);
    int purchaseCount = Integer.parseInt(amount) / 1000;

    System.out.printf("%d개를 구입했습니다.", purchaseCount);
    return purchaseCount;
  }

  private static void validate(String amount) {
    if (!isNumeric(amount)) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자 자료형이어야 합니다.");
    }
  }
}
