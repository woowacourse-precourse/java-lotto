package lotto;

public enum Ranking {
  THREE_MATCH(3, 5000),
  FOUR_MATCH(4, 50000),
  FIVE_MATCH(5, 1500000),
  FIVE_AND_BONUS(7, 30000000),
  SIX_MATCH(6, 2000000000);

  Ranking(int rank, int price) {
    this.rank = rank;
    this.price = price;
  }

  private final int rank;
  private final int price;


  public int getRank() {
    return rank;
  }

  public int getMoney() {
    return price;
  }
}
