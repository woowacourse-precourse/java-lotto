package lotto.constant;

public enum WinningStatisticsMessage {

  WINNING_STATISTICS("당첨 통계\n---"),
  SAME_THREE_NUMBER("3개 일치 (5,000원) - "),
  SAME_FOUR_NUMBER("4개 일치 (50,000원) - "),
  SAME_FIVE_NUMBER("5개 일치 (1,500,000원) - "),
  SAME_FIVE_AND_BONUS_NUMBER("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
  SAME_SIX_NUMBER("6개 일치 (2,000,000,000원) - "),
  NUMBER("개");

  private String message;

  WinningStatisticsMessage(String message) {
    this.message = message;
  }

  //TODO 인자의 갯수를 줄일 수 없을까
  public String print(int same3Num, int same4Num, int same5Num, int same5NumAndBonus, int same6Num) {
    StringBuilder sb = new StringBuilder();
    sb.append(WINNING_STATISTICS).append("\n")
      .append(SAME_THREE_NUMBER).append(same3Num).append(NUMBER).append("\n")
      .append(SAME_FOUR_NUMBER).append(same4Num).append(NUMBER).append("\n")
      .append(SAME_FIVE_NUMBER).append(same5Num).append(NUMBER).append("\n")
      .append(SAME_FIVE_AND_BONUS_NUMBER).append(same5NumAndBonus).append(NUMBER).append("\n")
      .append(SAME_SIX_NUMBER).append(same6Num).append(NUMBER).append("\n");
    return sb.toString();
  }

}
