package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

  private String purchaseMoney;
  private String winningNumbers;

  public int enterPurchaseMoney() {
    this.purchaseMoney = Console.readLine();
    return Integer.parseInt(purchaseMoney);
  }


  public List<Integer> enterWinningNumbers() {
    this.winningNumbers = Console.readLine();
    return changeTypeForSystem(replaceComma(winningNumbers));
  }

  private String replaceComma(String winningNumbers) {
    return winningNumbers.replace(",", "");
  }

  private List<Integer> changeTypeForSystem(String winningNumbers) {
    return Arrays.asList(Integer.parseInt(winningNumbers));
  }
}


