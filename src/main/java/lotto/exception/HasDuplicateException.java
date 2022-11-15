package lotto.exception;

public class HasDuplicateException extends IllegalArgumentException {
  public HasDuplicateException() {
    super("[ERROR] 중복되는 숫자가 있습니다.");
  }
}
