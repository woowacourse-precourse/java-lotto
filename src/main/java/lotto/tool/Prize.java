package lotto.tool;

public enum Prize {
  FIRST(1,6,false,2_000_000_000),
  SECOND(2,5,true,30_000_000),
  THIRD(3,5,false,1_500_000),
  FORTH(4,4,false,50_000),
  FIFTH(5,3,false,5_000);
  private final int ranking;
  private final int match;
  private final boolean isIncludeBonnus;
  private final int prizeMoney;
  Prize(int ranking, int match, boolean isIncludeBonnus, int prizeMoney){
    this.ranking=ranking;
    this.match=match;
    this.isIncludeBonnus=isIncludeBonnus;
    this.prizeMoney=prizeMoney;
  }

  public int getRanking() {
    return ranking;
  }

  public int getMatch() {
    return match;
  }

  public boolean isIncludeBonnus() {
    return isIncludeBonnus;
  }

  public int getPrizeMoney() {
    return prizeMoney;
  }
}
