package lotto.response;

public enum Message {

  INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
  INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

  private final String message;

  Message(String message) {
    this.message =  message;

  }

  @Override
  public String toString() {
    return this.message;
  }
}
