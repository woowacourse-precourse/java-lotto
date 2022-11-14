package lotto;

import static lotto.GameMessageManager.*;
import static lotto.InputUtil.*;

public class GameManager {
  private User user;

  public GameManager() {
    this.user = new User();
  }

  public void lottoGameStart() {
    buyLotto();
  }

  private void buyLotto() {
    printInputBuyAmountMessage();
    user.setBuyAmount(getIntegerInput());
    user.setBuyCount();
    printBuyCount(user.getBuyCount());
  }
}
