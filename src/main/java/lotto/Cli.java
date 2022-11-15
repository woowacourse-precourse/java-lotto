package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Validation.isNumeric;
import static lotto.response.Error.LOTTO_PURCHASE_MONETARY_UNIT_ERROR;
import static lotto.response.Error.LOTTO_PURCHASE_TYPE_ERROR;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

  /**
   * Function that receives answer numbers.
   * @return list of lotto number.
   */
  public static List<Integer> inputAnswerNumbers() {
    System.out.println("당첨 번호를 입력해 주세요.");
    String input = readLine();
    String[] inputArray = input.split(",");
    validate(inputArray);

    List<Integer> numbers = Arrays.stream(inputArray)
        .map(Integer::parseInt)
        .collect(Collectors.toList());

    Lotto.validate(numbers);
    return numbers;
  }

  public static void print(List<Lotto> lottoList) {
    System.out.printf("%d개를 구입했습니다.\n", lottoList.size());

    for(Lotto lotto: lottoList) {
      System.out.println(lotto);
    }
  }

  private static void validate(String amount) {
    if (!isNumeric(amount)) {
      throw new IllegalArgumentException(LOTTO_PURCHASE_TYPE_ERROR.toString());
    }
    if (Integer.parseInt(amount) % 1000 != 0) {
      throw new IllegalArgumentException(LOTTO_PURCHASE_MONETARY_UNIT_ERROR.toString());
    }
  }

  private static void validate(String[] numbers) {
    for(String number: numbers) {
      if (!isNumeric(number)) {
        throw new IllegalArgumentException(LOTTO_PURCHASE_TYPE_ERROR.toString());
      }
    }
  }
}
