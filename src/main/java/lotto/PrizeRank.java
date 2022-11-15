package lotto;

import java.text.DecimalFormat;
import java.util.Optional;

public enum PrizeRank {
  RANK_5(3, null, 5000),
  RANK_4(4, null, 50000),
  RANK_3(5, false, 1500000),
  RANK_2(5, true, 30000000),
  RANK_1(6, null, 2000000000);
  private static final String correctCountMessage = "개 일치";
  private static final String bonusNumberMessage = ", 보너스 볼 일치 ";
  private final int correctCount;
  private final Boolean isBonusNumberMatch;
  private final int prizeMoney;
  private int prizeCount;

  PrizeRank(int correctCount, Boolean isBonusNumberMatch, int prizeMoney) {
    this.correctCount = correctCount;
    this.isBonusNumberMatch = isBonusNumberMatch;
    this.prizeMoney = prizeMoney;
    this.prizeCount = 0;
  }

  public int getPrizeCount() {
    return this.prizeCount;
  }

  public static void resetAllCount() {
    for (PrizeRank prizeRank : PrizeRank.values()) {
      prizeRank.resetCount();
    }
  }

  public void increasePrizeCount() {
    this.prizeCount++;
  }

  private void resetCount() {
    this.prizeCount = 0;
  }

  public int getPrizeMoney() {
    return this.prizeMoney;
  }

  public boolean isSamePrizeRank(int correctCount, boolean isBonusNumberMatch) {
    if(this.isBonusNumberMatch == null){
      return this.correctCount == correctCount;
    }
    return this.correctCount == correctCount && this.isBonusNumberMatch == isBonusNumberMatch;
  }

  public String getMessage(int prizeCount) {
    return correctCount
        + correctCountMessage
        + getAdditionalMessage()
        + getMoneyString()
        + getPrizeCountString(prizeCount);
  }

  private String getMoneyString() {
    DecimalFormat decFormat = new DecimalFormat("###,###");
    return "(" + decFormat.format(prizeMoney) + "원)";
  }

  private String getPrizeCountString(int prizeCount) {
    return " - " + prizeCount + "개";
  }

  private String getAdditionalMessage() {
    if (Optional.ofNullable(isBonusNumberMatch).orElse(false)) return bonusNumberMessage;
    return " ";
  }
}
