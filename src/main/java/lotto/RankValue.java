package lotto;

public enum RankValue {
  FIVE_RANK("5등"),
  FOUR_RANK("4등"),
  THD_RANK("3등"),
  SCD_RANK("2등"),
  FST_RANK("1등"),
  NOTHING("당첨 X");

  private final String rank;

  RankValue(String rank) {
    this.rank = rank;
  }

  public String getRank() {
    return rank;
  }

}
