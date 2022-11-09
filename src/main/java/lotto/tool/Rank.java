package lotto.tool;

public enum Rank {
  FIRST(6,false,2_000_000_000),
  SECOND(5,true,30_000_000),
  THIRD(5,false,1_500_000),
  FORTH(4,false,50_000),
  FIFTH(3,false,5_000),
  LOSE(-1,false,0);

  private final int match;
  private final boolean isIncludeBonnus;
  private final int prizeMoney;
  Rank(int match, boolean isIncludeBonnus, int prizeMoney){
    this.match=match;
    this.isIncludeBonnus=isIncludeBonnus;
    this.prizeMoney=prizeMoney;
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
