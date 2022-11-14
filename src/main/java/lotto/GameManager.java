package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.GameMessageManager.*;

public class GameManager {
  public void lottoGameStart() {
    printInputBuyAmountMessage();
    int buyAmount = Integer.parseInt(Console.readLine());
    int buyCount = buyAmount / 1000;
    printBuyCount(buyCount);
  }
}
