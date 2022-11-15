package lotto;

import java.util.List;
import lotto.console.ConsoleInput;
import lotto.console.ConsoleOutput;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoPurchaseService;
import lotto.domain.ProfitRateCalculator;
import lotto.domain.WinningNumber;

public class Runner {

  private final LottoPurchaseService lottoPurchaseService;
  private final ConsoleInput consoleInput;
  private final ConsoleOutput consoleOutput;
  private final ProfitRateCalculator profitRateCalculator;

  public Runner(LottoPurchaseService lottoPurchaseService, ConsoleInput consoleInput,
      ConsoleOutput consoleOutput, ProfitRateCalculator profitRateCalculator) {
    this.lottoPurchaseService = lottoPurchaseService;
    this.consoleInput = consoleInput;
    this.consoleOutput = consoleOutput;
    this.profitRateCalculator = profitRateCalculator;
  }


  public void run() {
    try {
      int money = consoleInput.inputMoney();
      List<Lotto> purchasedLotto = lottoPurchaseService.purchase(money);
      consoleOutput.printLotto(purchasedLotto);
      WinningNumber winningNumber = consoleInput.inputWinningNumber();
      List<LottoPrize> result = winningNumber.draw(purchasedLotto);
      double profileRate = profitRateCalculator.calculate(result);
      consoleOutput.printResult(result, profileRate);
    } catch (IllegalArgumentException e) {
      System.out.println("[ERROR] " + e.getMessage());
    }
  }
}
