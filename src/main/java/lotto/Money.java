package lotto;

public class Money {
  private static boolean checkMoneyIsDigit(String userMoney) {
    for (int i = 0; i < userMoney.length(); i++)
    {
      if (!Character.isDigit(userMoney.charAt(i))) {
        throw new IllegalArgumentException(Constant.NOT_ONLY_DIGIT.getMessage());
      }
    }
    return true;
  }

  private static boolean checkDividableMoney(String userMoney) {
    int money = Integer.parseInt(userMoney);

    if (money % 1000 != 0) {
      throw new IllegalArgumentException(Constant.NOT_1000.getMessage());
    }
    return true;
  }

  public static int countLotto(String userMoney) {
    int money = Integer.parseInt(userMoney);

    if (checkDividableMoney(userMoney) && checkMoneyIsDigit(userMoney)) {
      return (money / 1000);
    }
    return -1;
  }
}
