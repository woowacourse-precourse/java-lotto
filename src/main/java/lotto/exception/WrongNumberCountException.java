package lotto.exception;

public class WrongNumberCountException extends IllegalArgumentException {
  public WrongNumberCountException() {
    super("[ERROR] 숫자의 개수가 잘못되었습니다.");
  }
}
