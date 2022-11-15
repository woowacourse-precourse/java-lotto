package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

  private static final String DELIMITER = ",";

  public static int inputPurchaseMoney() throws IllegalArgumentException{
    System.out.println("로또 구입 금액을 입력해주세요.");
    String purchaseMoney = Console.readLine();
    return convertToInt(purchaseMoney);
  }
  
  public static List<Integer> inputWinningNumber() {
    System.out.println("로또 당첨 번호를 입력해주세요.");
    String winningNumber = Console.readLine();
    return splitByDelimiter(winningNumber);
  }

  public static int inputBonusNumber() {
    System.out.println("로또 보너스 번호를 입력해주세요.");
    String bonusNumber = Console.readLine();
    return convertToInt(bonusNumber);
  }

  private static int convertToInt(String input) throws IllegalArgumentException {
    try {
      return Integer.parseInt(input);
    } catch (Exception e) {
      System.out.println("[ERROR] 숫자가 아닌 값을 입력하였습니다.");
      throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력하였습니다.");
    }
  }

  private static List<Integer> splitByDelimiter(String input) {
    try {
      List<String> numbers = List.of(input.split(DELIMITER));
      return numbers.stream()
              .map(s -> convertToInt(s))
              .collect(Collectors.toList());
    } catch (Exception e) {
      throw new IllegalArgumentException("[ERROR] 값을 올바르게 입력하지 않았습니다.");
    }
  }
}
