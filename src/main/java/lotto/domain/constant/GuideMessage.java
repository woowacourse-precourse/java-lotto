package lotto.domain.constant;

public enum GuideMessage {
  INPUT_MONEY("구입금액을 입력해 주세요."),
  OUTPUT_NUM_OF_LOTTO("개를 구매했습니다."),
  INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
  INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

  private String message;

  GuideMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
