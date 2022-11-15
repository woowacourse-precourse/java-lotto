package lotto.console;

public enum ConsoleMessage {

  INPUT_MONEY("구입금액을 입력해주세요"),
  INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
  INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
  OUTPUT_RESULT_MESSAGE("당첨 통계 \n---"),
  OUTPUT_FIRST_MESSAGE("6개 일치 (2,000,000,000원) - "),
  OUTPUT_SECOND_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
  OUTPUT_THIRD_MESSAGE("5개 일치 (1,500,000원) - "),
  OUTPUT_FOURTH_MESSAGE("4개 일치 (50,000원) - "),
  OUTPUT_FIFTH_MESSAGE("3개 일치 (5,000원) - ");

  private String mesage;

  ConsoleMessage(String mesage) {
    this.mesage = mesage;
  }

  public String getMesage() {
    return mesage;
  }
}
