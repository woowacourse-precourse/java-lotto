package lotto.exception;

public class BuyAmountCanNotDividedByLottoPrice extends IllegalArgumentException {
  public BuyAmountCanNotDividedByLottoPrice() {
    super("[ERROR] 입력 금액의 단위가 잘못되었습니다.");
  }
}
