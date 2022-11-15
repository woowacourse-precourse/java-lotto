package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Validation.validateAnswer;
import static lotto.Validation.validateBonus;
import static lotto.Validation.validatePurchase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
   * Function that receives answer numbers.
   * @return list of lotto number.
   */
  public static List<Integer> inputAnswerNumbers() {
    System.out.println("당첨 번호를 입력해 주세요.");
    String input = readLine();
    String[] inputArray = input.split(",");
    validateAnswer(inputArray);

    return Arrays.stream(inputArray)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

  /**
   * Function that receives bonus numbers.
   * @return The number of bonus.
   */
  public static Integer inputBonusNumber() {
    System.out.println("보너스 번호를 입력해 주세요.");
    String number = readLine();
    validateBonus(number);
    return Integer.parseInt(number);
  }

  public static void print(List<Lotto> lottoList) {
    System.out.printf("%d개를 구입했습니다.\n", lottoList.size());

    for(Lotto lotto: lottoList) {
      System.out.println(lotto);
    }
  }
}
