package lotto.message;

public enum ErrorMessage {
  NOT_RANGE_MESSAGE("[ERROR] 1 ~ 45 범위의 숫자가 아닙니다."),
  NOT_ONLY_DIGIT("[ERROR] 숫자만 입력해주세요."),
  NOT_1000("[ERROR] 1000원 단위로 입력해 주세요."),
  NOT_ONLY_ONE("[ERROR] 하나의 숫자만 입력해 주세요."),
  NOT_ONLY_NUMBER("[ERROR] 당첨 번호와 중복되어 있습니다."),
  NOT_SIX_NUMBERS("[ERROR] 6개의 숫자만 입력해주세요."),
  NOT_ONLY_WINNING_NUMBER("[ERROR] 중복된 숫자를 입력하였습니다.");

  private final String message;

  ErrorMessage(String value) {
    this.message = value;
  }

  public String getMessage() {
    return message;
  }
}
