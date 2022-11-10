package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Money {
  public boolean checkMoneyIsDigit(String userMoney) {
    for (int i = 0; i < userMoney.length(); i++)
    {
      if (!Character.isDigit(userMoney.charAt(i))) {
        throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
      }
    }
    return true;
  }

  public boolean checkDividableMoney(String userMoney) {
    int money = Integer.parseInt(userMoney);

    if (money % 1000 != 0) {
      throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
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
