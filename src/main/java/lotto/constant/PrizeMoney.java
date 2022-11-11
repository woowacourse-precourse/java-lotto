package lotto.constant;

public enum PrizeMoney {

  SAME_THREE(5000),
  SAME_FOUR(50000),
  SAME_FIVE(1500000),
  SAME_FIVE_AND_BONUS(30000000),
  SAME_SIX(2000000000);

  private int prizeMoney;

  PrizeMoney(int prizeMoney) {
    this.prizeMoney = prizeMoney;
  }
}
