package lotto;

import java.util.List;

public class User {
  private int buyAmount;
  private int buyCount;
  private List<Lotto> userLottoList;
  private int prizeMoney;

  public void setBuyAmount(int buyAmount) {
    checkValidBuyAmount(buyAmount);
    this.buyAmount = buyAmount;
  }

  private void checkValidBuyAmount(int buyAmount) {
    checkOverZero(buyAmount);
    checkBuyAmountDividedByLottoPrice(buyAmount);
  }

  private void checkOverZero(int buyAmount) {
    if (buyAmount <= 0) {
      throw new IllegalArgumentException("입력 금액이 0 이하입니다!");
    }
  }

  private void checkBuyAmountDividedByLottoPrice(int buyAmount) {
    if (buyAmount % Lotto.PRICE == 0) {
      throw new IllegalArgumentException("입력 금액의 단위가 잘못되었습니다!");
    }
  }
}
