package lotto.domain;

import java.util.Arrays;

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

  private boolean isMatchNumbersCount(int matchCount, int bonusCount) {
    return matchCount == matchNumberCount && bonusCount == matchBonusCount;
  }

  private static LottoPrize findPrizeByCounts(int matchCount, int bonusCount) {
    return Arrays.stream(LottoPrize.values())
        .filter(prize -> prize.isMatchNumbersCount(matchCount, bonusCount))
        .findAny()
        .orElse(LottoPrize.MATCH_NOTING);
  }


  public static LottoPrize of(int matchCount, int bonusCount) {
    return findPrizeByCounts(matchCount, bonusCount);
  }
}
