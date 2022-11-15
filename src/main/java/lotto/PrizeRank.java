package lotto;

import java.text.DecimalFormat;

public enum PrizeRank {
  RANK_5(3, false, 5000),
  RANK_4(4, false, 50000),
  RANK_3(5, false, 1500000),
  RANK_2(5, true, 30000000),
  RANK_1(6, false, 2000000000);
  private static final String correctCountMessage = "개 일치";
  private static final String bonusNumberMessage = ", 보너스 볼 일치 ";
  private final int correctCount;
  private final boolean isBonusNumberMatch;
  private final int prizeMoney;

  PrizeRank(int correctCount, boolean isBonusNumberMatch, int prizeMoney) {
    this.correctCount = correctCount;
    this.isBonusNumberMatch = isBonusNumberMatch;
    this.prizeMoney = prizeMoney;
  }

  public static PrizeRank getPrizeRank(int correctCount, boolean isCheckBonusNumber) {
    for (PrizeRank prizeRank : PrizeRank.values()) {
      if (checkSamePrizeRank(correctCount, isCheckBonusNumber, prizeRank)) {
        return prizeRank;
      }
    }
    return null;
  }

  private static boolean checkSamePrizeRank(
      int correctCount, boolean isBonusNumberMatch, PrizeRank prizeRank) {
    return prizeRank.correctCount == correctCount
        && prizeRank.isBonusNumberMatch == isBonusNumberMatch;
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
    if (isBonusNumberMatch) return bonusNumberMessage;
    return " ";
  }
}
