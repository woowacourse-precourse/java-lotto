package lotto.console;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput {

  static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

  public int inputMoney() {
    System.out.println(INPUT_MONEY_MESSAGE);
    String money = Console.readLine();
    validateIsNumeric(money);
    return Integer.parseInt(money);
  }

  private void validateIsNumeric(String str) {
    boolean check = str != null && str.matches("[0-9]*");
    if (!check) {
      System.out.println("[ERROR] 숫자여야 합니다.");
      throw new IllegalArgumentException();
    }
  }

}
