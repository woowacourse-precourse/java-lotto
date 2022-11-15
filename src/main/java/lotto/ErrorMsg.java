package lotto;

import java.util.NoSuchElementException;

public enum ErrorMsg {
  INPUT_ERROR("[ERROR] 숫자만 입력 가능합니다."),
  UNIT_ERROR("[ERROR] 1000원 단위만 입력할 수 있습니다."),
  SEPARATOR_ERROR("[ERROR] 구분자 \",\"를 포함해야 합니다."),
  INPUT_COUNT_ERROR("[ERROR] 숫자 6개를 입력해야 합니다."),
  RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

  private final String message;

  ErrorMsg(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
