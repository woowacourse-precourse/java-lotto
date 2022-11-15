package lotto;

public enum UiValue {
  BUY_MONEY_INPUT("구입금액을 입력해 주세요."),
  BUY_LOTTO_CNT("%d개를 구매했습니다.\n"),
  WINNIG_NUMBERS_INPUT("당첨 번호를 입력해 주세요."),
  BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요."),
  WINNING_YIELD_OUTPUT("당첨 통계\n---"),
  FIVE_RANK("3개 일치 (5,000원) - %d개\n"),
  FOUR_RANK("4개 일치 (50,000원) - %d개\n"),
  THD_RANK("5개 일치 (1,500,000원) - %d개\n"),
  SCD_RANK("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
  FST_RANK("6개 일치 (2,000,000,000원) - %d개\n"),
  YIELD_OUTPUT("총 수익률은 %s입니다.");

  private final String uiValue;

  UiValue(String uiValue) {
    this.uiValue = uiValue;
  }

  public String getUiValue() {
    return uiValue;
  }

}
