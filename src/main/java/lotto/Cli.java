package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Validation.validateBonus;
import static lotto.Validation.validatePurchase;
import static lotto.Validation.validateWinning;
import static lotto.response.Message.INPUT_BONUS_NUMBER;
import static lotto.response.Message.INPUT_WINNING_NUMBER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

/** Cli class to interact with user. */
public class Cli {

  /**
   * Function that receives user input to purchase lotto.
   * @return amount of purchase.
   */
  public static int inputPurchaseAmount() {
    System.out.println("구입금액을 입력해 주세요.");
    String amount = readLine();

    validatePurchase(amount);
    return Integer.parseInt(amount);
  }

  /**
   * Function that receives winning numbers.
   * @return list of lotto number.
   */
  public static List<Integer> inputWinningNumbers() {
    System.out.println(INPUT_WINNING_NUMBER);
    String input = readLine();
    String[] numbers = input.split(",");
    validateWinning(numbers);

    return Arrays.stream(numbers)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

  /**
   * Function that receives bonus numbers.
   * @return The number of bonus.
   */
  public static Integer inputBonusNumber() {
    System.out.println(INPUT_BONUS_NUMBER);
    String number = readLine();
    validateBonus(number);
    return Integer.parseInt(number);
  }

  public static void print(List<Lotto> lottoList) {
    System.out.printf("%d개를 구매했습니다.\n", lottoList.size());

    for(Lotto lotto: lottoList) {
      System.out.println(lotto);
    }
  }
}
