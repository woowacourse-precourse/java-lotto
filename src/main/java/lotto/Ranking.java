package lotto;

public enum Ranking {
  THREE_MATCH(3, 5000, "3개 일치 (5,000원) - "),
  FOUR_MATCH(4, 50000, "4개 일치 (50,000원) - "),
  FIVE_MATCH(5, 1500000, "5개 일치 (1,500,000원) - "),
  FIVE_AND_BONUS(7, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
  SIX_MATCH(6, 2000000000, "6개 일치 (2,000,000,000원) - ");

  Ranking(int rank, int price, String message) {
    this.rank = rank;
    this.price = price;
    this.message = message;
  }

  private final int rank;
  private final int price;

  private final String message;

  public int getRank() {
    return rank;
  }

  public int getMoney() {
    return price;
  }
  public String getMessage() {
    return message;
  }
}
