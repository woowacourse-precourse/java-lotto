package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

  private String purchaseMoney;

  public int enterPurchaseMoney() {
    this.purchaseMoney = Console.readLine();
    return Integer.parseInt(purchaseMoney);
  }
}

