package lotto.exception;

public class NumberOutOfRangeException extends IllegalArgumentException {
  public NumberOutOfRangeException() {
    super("[ERROR] 범위를 벗어나는 숫자가 있습니다.");
  }
}
