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


}
