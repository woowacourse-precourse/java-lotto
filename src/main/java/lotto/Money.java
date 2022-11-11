package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Money {
  public boolean checkMoneyIsDigit(String userMoney) {
    for (int i = 0; i < userMoney.length(); i++)
    {
      if (!Character.isDigit(userMoney.charAt(i))) {
        throw new IllegalArgumentException(Constant.NOT_ONLY_DIGIT);
      }
    }
    return true;
  }

  public boolean checkDividableMoney(String userMoney) {
    int money = Integer.parseInt(userMoney);

    if (money % 1000 != 0) {
      throw new IllegalArgumentException(Constant.NOT_1000);
    }
    return true;
  }

  public int countLotto(String userMoney) {
    int money = Integer.parseInt(userMoney);

    if (checkDividableMoney(userMoney) && checkMoneyIsDigit(userMoney)) {
      return (money / 1000);
    }
    return -1;
  }
}
