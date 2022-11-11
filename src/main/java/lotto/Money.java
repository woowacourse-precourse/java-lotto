package lotto;

import java.util.Map;

public class Money {
  private static int money;
  private static boolean checkMoneyIsDigit(String userMoney) {
    for (int i = 0; i < userMoney.length(); i++)
    {
      if (!Character.isDigit(userMoney.charAt(i))) {
        throw new IllegalArgumentException(ErrorMessage.NOT_ONLY_DIGIT.getMessage());
      }
    }
    return true;
  }

  private static boolean checkDividableMoney(String userMoney) {
    int money = Integer.parseInt(userMoney);

    if (money % 1000 != 0) {
      throw new IllegalArgumentException(ErrorMessage.NOT_1000.getMessage());
    }
    return true;
  }

  public static int countLotto(String userMoney) {
    money = Integer.parseInt(userMoney);

    if (checkDividableMoney(userMoney) && checkMoneyIsDigit(userMoney)) {
      return (money / 1000);
    }
    return -1;
  }

  public static double percentage(Map<Integer, Integer> maps) {
    int third = maps.getOrDefault(Ranking.THREE_MATCH.getRank(), 0) * Ranking.THREE_MATCH.getMoney();
    int forth = maps.getOrDefault(Ranking.FOUR_MATCH.getRank(), 0) * Ranking.FOUR_MATCH.getMoney();
    int fifth = maps.getOrDefault(Ranking.FIVE_MATCH.getRank(), 0) * Ranking.FIVE_MATCH.getMoney();
    int fifthBonus = maps.getOrDefault(Ranking.FIVE_AND_BONUS.getRank(), 0) * Ranking.FIVE_AND_BONUS.getMoney();
    int sixth = maps.getOrDefault(Ranking.SIX_MATCH.getRank(), 0) * Ranking.SIX_MATCH.getMoney();

    double sumAll = third + forth + fifth + fifthBonus + sixth + 0.0;
    double result = sumAll / money;
    return Math.round(result * 1000) / 10.0;
  }
}
