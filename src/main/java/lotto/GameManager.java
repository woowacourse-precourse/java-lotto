package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.GameMessageManager.*;
import static lotto.InputUtil.*;

public class GameManager {
  public void lottoGameStart() {
    printInputBuyAmountMessage();
    int buyAmount = getIntegerInput();
    int buyCount = buyAmount / 1000;
    printBuyCount(buyCount);
  }
}
