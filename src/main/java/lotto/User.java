package lotto;

import lotto.exception.BuyAmountCanNotDividedByLottoPrice;
import lotto.exception.BuyAmountUnderZeroException;

import java.util.List;

public class User {
  private int buyAmount;
  private int buyCount;
  private List<Lotto> userLottoList;
  private int prizeMoney;

  public int getBuyCount() {
    return this.buyCount;
  }

  public void setBuyAmount(int buyAmount) {
    checkValidBuyAmount(buyAmount);
    this.buyAmount = buyAmount;
  }

  public void setBuyCount() {
    this.buyCount = buyAmount / Lotto.PRICE;
  }

  public List<Lotto> getUserLottoList() {
    return this.userLottoList;
  }

  public void setUserLottoList(List<Lotto> userLottoList) {
    this.userLottoList = userLottoList;
  }

  public void printUserLottoList() {
    for (Lotto lotto : userLottoList) {
      System.out.println(lotto.getLottoString());
    }
  }

  public void setPrizeMoney(int prizeMoney) {
    this.prizeMoney = prizeMoney;
  }

  public float calculateReturnRate() {
    return 100.0f * this.prizeMoney / this.buyAmount;
  }

  private void checkValidBuyAmount(int buyAmount) {
    checkOverZero(buyAmount);
    checkBuyAmountDividedByLottoPrice(buyAmount);
  }

  private void checkOverZero(int buyAmount) {
    if (buyAmount <= 0) {
      throw new BuyAmountUnderZeroException();
    }
  }

  private void checkBuyAmountDividedByLottoPrice(int buyAmount) {
    if (buyAmount % Lotto.PRICE != 0) {
      throw new BuyAmountCanNotDividedByLottoPrice();
    }
  }
}
