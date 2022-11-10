package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Money {
  public String inputMoney() {
    return Console.readLine();
  }

  //예외 발생은 어디서 시켜야 할까..
  // 두 예외를 한번에 검사하는 곳에서 하는게 맞지 않을까
  public boolean checkMoneyIsDigit(String userMoney) {
    for (int i = 0; i < userMoney.length(); i++)
    {
      if (!Character.isDigit(userMoney.charAt(i))) {
        PrintOut.isNotDigitMessage();
        throw new IllegalArgumentException();
      }// 추후 에러 내용을 출력하는 메세지 추가
    }
    return true;
  }

  public boolean checkDividableMoney(String userMoney) throws IllegalArgumentException{
    int money = Integer.parseInt(userMoney);

    if (money % 1000 != 0) {
      PrintOut.isNotValuableMoneyMessage();
      throw new IllegalArgumentException();
    } // 추후 에러 내용을 출력하는 메세지 추가
    return true;
  }

  public boolean isValidMoney(String userMoney) {
    return checkDividableMoney(userMoney) && checkMoneyIsDigit(userMoney);
  }
}
