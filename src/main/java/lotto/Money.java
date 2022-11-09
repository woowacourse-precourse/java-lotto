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
        throw new IllegalArgumentException(); // 추후 에러 내용을 출력하는 메세지 추가
    }
    return true;
  }

  public boolean checkDividableMoney() {
    String userMoney = inputMoney();
    int money = Integer.parseInt(userMoney);

    if (money % 1000 != 0)
        throw new IllegalArgumentException(); // 추후 에러 내용을 출력하는 메세지 추가
    return true;
  }
}
