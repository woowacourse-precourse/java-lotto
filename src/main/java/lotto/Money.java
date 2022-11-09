package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Money {
  public String inputMoney() {
    return Console.readLine();
  }

  public boolean checkMoneyIsDigit() {
    String userMoney = inputMoney();

    for (int i = 0; i < userMoney.length(); i++)
    {
      if (!Character.isDigit(userMoney.charAt(i)))
        throw new IllegalArgumentException();
    }
    return true;
  }

  public boolean checkDividableMoney() {

    return true;
  }
}
