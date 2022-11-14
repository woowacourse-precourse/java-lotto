package lotto.domain.constant;

public enum PrizeMoney {

  SAME_THREE(5_000, "(5,000원)"),
  SAME_FOUR(50_000, "(50,000원)"),
  SAME_FIVE(1_500_000, "(1,500,000원)"),
  SAME_FIVE_AND_BONUS(30_000_000, "(30,000,000원)"),
  SAME_SIX(2_000_000_000, "(2,000,000,000원)");

  private int prizeMoney;
  private String prizeMoneyInKorean;

  PrizeMoney(int prizeMoney, String prizeMoneyInKorean) {
    this.prizeMoney = prizeMoney;
    this.prizeMoneyInKorean = prizeMoneyInKorean;
  }

  public int getPrizeMoney() {
    return prizeMoney;
  }
  public String getPrizeMoneyInKorean() {
    return prizeMoneyInKorean;
  }
}
