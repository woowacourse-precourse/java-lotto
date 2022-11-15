package lotto.constant;


public enum LottoRank {
  NONE(0, 0, 0L),
  FIFTH(3, 0, 5000L),
  FOURTH(4, 0, 50000L),
  THIRD(5, 0, 1500000L),
  SECOND(5, 1, 30000000L),
  FIRST(6, 0, 2000000000L);

  private final Integer matchingCount;
  private final Integer bonusMatchingCount;
  private final Long price;

  LottoRank(int matchingCount, int bonusMatchingCount, Long price) {
    this.matchingCount = matchingCount;
    this.bonusMatchingCount = bonusMatchingCount;
    this.price = price;
  }

  // 리팩터링 필요
  public static LottoRank findRank(Integer matchingCount, Integer bonusMatchingCount) {

    if(matchingCount.equals(FIFTH.getMatchingCount()) && bonusMatchingCount.equals(FIFTH
        .getBonusMatchingCount())) return FIFTH;

    if(matchingCount.equals(FOURTH.getMatchingCount()) && bonusMatchingCount.equals(FOURTH
        .getBonusMatchingCount())) return FOURTH;

    if(matchingCount.equals(THIRD.getMatchingCount()) && bonusMatchingCount.equals(THIRD
        .getBonusMatchingCount())) return THIRD;

    if(matchingCount.equals(SECOND.getMatchingCount()) && bonusMatchingCount.equals(SECOND
        .getBonusMatchingCount())) return SECOND;

    if(matchingCount.equals(FIRST.getMatchingCount()) && bonusMatchingCount.equals(FIRST
        .getBonusMatchingCount())) return FIRST;

    return NONE;
  }

  public Integer getMatchingCount() {
    return matchingCount;
  }

  public Integer getBonusMatchingCount() {
    return bonusMatchingCount;
  }

  public Long price() {
    return price;
  }
}
