package lotto;

import static lotto.GameMessageManager.*;
import static lotto.InputUtil.*;

public class GameManager {
  public void lottoGameStart() {
    printInputBuyAmountMessage();
    int buyAmount = getIntegerInput();
    int buyCount = getBuyCountByBuyAmount(buyAmount);
    printBuyCount(buyCount);
  }

  private int getBuyCountByBuyAmount(int buyAmount){
    return buyAmount / Lotto.PRICE;
  }


}
