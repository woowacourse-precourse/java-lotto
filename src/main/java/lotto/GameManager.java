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
    user.printUserLottoList();
  }

  private void buyLotto() {
    printInputBuyAmountMessage();
    user.setBuyAmount(getIntegerInput());
    user.setBuyCount();
    printBuyCount(user.getBuyCount());
    user.setUserLottoList(LottoGenerator.getRandomLottoListByCount(user.getBuyCount()));
  }
}
