package lotto.constant;

public enum WinningStatisticsMessage {

  NUMBER("개"),
  SAME_THREE_NUMBER("3개 일치 (5,000원) - "),
  SAME_FOUR_NUMBER("4개 일치 (50,000원) - "),
  SAME_FIVE_NUMBER("5개 일치 (1,500,000원) - "),
  SAME_FIVE_AND_BONUS_NUMBER("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
  SAME_SIX_NUMBER("6개 일치 (2,000,000,000원) - ");

  private String message;

  WinningStatisticsMessage(String message) {
    this.message = message;
  }

}