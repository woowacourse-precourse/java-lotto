package lotto.exception;

public class NotNumberException extends IllegalArgumentException {
  public NotNumberException() {
    super("[ERROR] 숫자가 아닙니다.");
  }
}
