package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Validation.isNumeric;
import static lotto.response.Error.LOTTO_PURCHASE_MONETARY_UNIT_ERROR;
import static lotto.response.Error.LOTTO_PURCHASE_TYPE_ERROR;

/** Cli class to interact with user. */
public class Cli {

  /**
   * Function that receives user input to purchase lotto.
   * @return amount of purchase.
   */
  public static int getPurchaseAmount() {
    System.out.println("구입금액을 입력해 주세요.");
    String amount = readLine();

    validate(amount);
    return Integer.parseInt(amount);
  }

  private static void validate(String amount) {
    if (!isNumeric(amount)) {
      throw new IllegalArgumentException(LOTTO_PURCHASE_TYPE_ERROR.toString());
    }
    if (Integer.parseInt(amount) % 1000 != 0) {
      throw new IllegalArgumentException(LOTTO_PURCHASE_MONETARY_UNIT_ERROR.toString());
    }
  }
}
