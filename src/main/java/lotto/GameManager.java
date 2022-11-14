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
    printBuyLottoList();
    Lotto prizeLotto = getPrizeNumber();
  }

  private void buyLotto() {
    printInputBuyAmountMessage();
    user.setBuyAmount(getIntegerInput());
    user.setBuyCount();
    printBlankLine();
  }

  private void printBuyLottoList(){
    printBuyCount(user.getBuyCount());
    user.setUserLottoList(LottoGenerator.getRandomLottoListByCount(user.getBuyCount()));
    user.printUserLottoList();
    printBlankLine();
  }

  private Lotto getPrizeNumber(){
    printInputPrizeNumberMessage();
    return getPrizeLotto();
  }
}
