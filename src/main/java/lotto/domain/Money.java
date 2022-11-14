package lotto.domain;

import lotto.message.ErrorMessage;
import lotto.Ranking;

import java.util.Map;

public class Money {
  private static long money;
  public static long count;

  // 입력된 money가 숫자로만 이루어져 있는지.
  public static void checkMoneyIsDigit(String userMoney) {
    for (int i = 0; i < userMoney.length(); i++)
    {
      if (!Character.isDigit(userMoney.charAt(i))) {
        throw new IllegalArgumentException(ErrorMessage.NOT_ONLY_DIGIT.getMessage());
      }
    }
  }

  // 입력된 money가 1000원 단위로 나누어 떨어지는지
  public static void checkDividableMoney() {
    if (money % 1000 != 0) {
      throw new IllegalArgumentException(ErrorMessage.NOT_1000.getMessage());
    }
  }

  //1000원으로 나눠서 구매할 로또의 개수 반환
  public static void countLotto(String userMoney) {
    checkMoneyIsDigit(userMoney);
    money = Integer.parseInt(userMoney);
    checkDividableMoney();
    count = (money / 1000);
  }

  public static String percentage(Map<Integer, Integer> maps) {
    int threeMatchMoney = maps.getOrDefault(Ranking.THREE_MATCH.getRank(), 0) * Ranking.THREE_MATCH.getMoney();
    int fourMatchMoney = maps.getOrDefault(Ranking.FOUR_MATCH.getRank(), 0) * Ranking.FOUR_MATCH.getMoney();
    int fiveMatchMoney = maps.getOrDefault(Ranking.FIVE_MATCH.getRank(), 0) * Ranking.FIVE_MATCH.getMoney();
    int fiveBonusMatchMoney = maps.getOrDefault(Ranking.FIVE_AND_BONUS.getRank(), 0) * Ranking.FIVE_AND_BONUS.getMoney();
    int sixMatchMoney = maps.getOrDefault(Ranking.SIX_MATCH.getRank(), 0) * Ranking.SIX_MATCH.getMoney();

    long sumAll = (long) (threeMatchMoney + fourMatchMoney + fiveMatchMoney + fiveBonusMatchMoney + sixMatchMoney + 0.0);
    double result = ((double) sumAll / money) * 100;
    return String.format(String.format("%.1f", result));
  }
}
