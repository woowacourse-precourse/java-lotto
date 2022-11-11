package lotto;

public enum ErrorMessage {  // Enum으로 관리하는게 좋을 듯!!
  NOT_RANGE_MESSAGE("[ERROR] 1 ~ 45 범위의 숫자가 아닙니다."),
  NOT_ONLY_DIGIT("[ERROR] 숫자만 입력해주세요."),
  NOT_1000("[ERROR] 1000원 단위로 입력해 주세요.");

  private final String message;

  ErrorMessage(String value) {
    this.message = value;
  }

  public String getMessage() {
    return message;
  }
}
