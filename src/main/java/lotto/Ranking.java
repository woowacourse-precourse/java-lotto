package lotto;

public enum Ranking {
  THREE_MATCH(3),
  FOUR_MATCH(4),
  FIVE_MATCH(5),
  FIVE_AND_BONUS(7),
  SIX_MATCH(6);

  Ranking(int rank) {
    this.rank = rank;
  }

  private final int rank;


  public int getRank() {
    return rank;
  }
}
