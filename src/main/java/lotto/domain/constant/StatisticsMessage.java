package lotto.domain.constant;

import lotto.dto.StatisticsDto;

public enum StatisticsMessage {

  STATISTICS("당첨 통계\n---"),
  SAME_THREE_NUMBER("3개 일치 " + PrizeMoney.SAME_THREE.getPrizeMoneyInKorean() + " - "),
  SAME_FOUR_NUMBER("4개 일치 " + PrizeMoney.SAME_FOUR.getPrizeMoneyInKorean() + " - "),
  SAME_FIVE_NUMBER("5개 일치 " + PrizeMoney.SAME_FIVE.getPrizeMoneyInKorean() + " - "),
  SAME_FIVE_AND_BONUS_NUMBER("5개 일치, 보너스 볼 일치 " + PrizeMoney.SAME_FIVE_AND_BONUS.getPrizeMoneyInKorean() + " - "),
  SAME_SIX_NUMBER("6개 일치 " + PrizeMoney.SAME_SIX.getPrizeMoneyInKorean() + " - "),
  NUMBER("개");

  private String message;

  StatisticsMessage(String message) {
    this.message = message;
  }

  public String print(StatisticsDto dto) {
    StringBuilder sb = new StringBuilder();
    sb.append("\n")
      .append(STATISTICS.message).append("\n")
      .append(SAME_THREE_NUMBER.message).append(dto.getSame3Num()).append(NUMBER.message).append("\n")
      .append(SAME_FOUR_NUMBER.message).append(dto.getSame4Num()).append(NUMBER.message).append("\n")
      .append(SAME_FIVE_NUMBER.message).append(dto.getSame5Num()).append(NUMBER.message).append("\n")
      .append(SAME_FIVE_AND_BONUS_NUMBER.message).append(dto.getSame5AndBonusNum()).append(NUMBER.message).append("\n")
      .append(SAME_SIX_NUMBER.message).append(dto.getSame6Num()).append(NUMBER.message);
    return sb.toString();
  }

}
