package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

  public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
  public static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
  public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";


  public static String userMoney() {
    System.out.println(INPUT_MONEY_MESSAGE);
    return Console.readLine();
  }

  public static String winningNumber() {
    System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
    return Console.readLine();
  }

  public static String bonusNumber() {
    System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    return Console.readLine();
  }
}
