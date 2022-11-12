package lotto.domain.constant;

public enum PrizeMoney {

  SAME_THREE(5_000),
  SAME_FOUR(50_000),
  SAME_FIVE(1_500_000),
  SAME_FIVE_AND_BONUS(30_000_000),
  SAME_SIX(2_000_000_000);

  private int prizeMoney;

  PrizeMoney(int prizeMoney) {
    this.prizeMoney = prizeMoney;
  }
}
