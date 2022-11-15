package lotto.domain;

public enum LottoPrize {
  FIFTH(3, 0, 5000),
  FOURTH(4, 0, 50000),
  THIRD(5, 0, 1500000),
  SECOND(5, 1, 30000000),
  FIRST(6, 0, 2000000000),
  MATCH_NOTING(0, 0, 0);

  private final int matchNumberCount;
  private final int matchBonusCount;
  private final int money;

  LottoPrize(int matchNumberCount, int matchBonusCount, int money) {
    this.matchNumberCount = matchNumberCount;
    this.matchBonusCount = matchBonusCount;
    this.money = money;
  }

  public int getMatchNumberCount() {
    return matchNumberCount;
  }

  public int getMatchBonusCount() {
    return matchBonusCount;
  }

  public int getMoney() {
    return money;
  }

  private static boolean isMatchNumbersCount(int matchCount, int bonusCount, LottoPrize prize) {
    return matchCount == prize.getMatchNumberCount() && bonusCount == prize.getMatchBonusCount();
  }

  public static LottoPrize of(int matchCount, int bonusCount) {
    if (isMatchNumbersCount(matchCount, bonusCount, LottoPrize.FIFTH)) {
      return LottoPrize.FIFTH;
    }

    if (isMatchNumbersCount(matchCount, bonusCount, LottoPrize.FOURTH)) {
      return LottoPrize.FOURTH;
    }

    if (isMatchNumbersCount(matchCount, bonusCount, LottoPrize.THIRD)) {
      return LottoPrize.THIRD;
    }

    if (isMatchNumbersCount(matchCount, bonusCount, LottoPrize.SECOND)) {
      return LottoPrize.SECOND;
    }

    if (isMatchNumbersCount(matchCount, bonusCount, LottoPrize.FIRST)) {
      return LottoPrize.FIRST;
    }

    return LottoPrize.MATCH_NOTING;
  }
}
