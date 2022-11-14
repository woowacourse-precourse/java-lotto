package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.GameMessageManager.*;
import static lotto.InputUtil.*;

public class GameManager {
  public static final int LOTTO_PRICE = 1000;
  public void lottoGameStart() {
    printInputBuyAmountMessage();
    int buyAmount = getIntegerInput();
    int buyCount = getBuyCountByBuyAmount(buyAmount);
    printBuyCount(buyCount);
  }

  private int getBuyCountByBuyAmount(int buyAmount){
    return buyAmount / LOTTO_PRICE;
  }
}
