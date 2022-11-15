package lotto.exception;

public class BuyAmountUnderZeroException extends IllegalArgumentException {
  public BuyAmountUnderZeroException() {
    super("[ERROR] 입력 금액이 0 이하입니다.");
  }
}
