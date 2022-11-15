package lotto;

import lotto.console.ConsoleInput;
import lotto.console.ConsoleOutput;
import lotto.domain.LottoPurchaseService;
import lotto.domain.ProfitRateCalculator;

public class Application {

  public static void main(String[] args) {
    ConsoleInput consoleInput = new ConsoleInput();
    ConsoleOutput consoleOutput = new ConsoleOutput();
    LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();
    ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator();

    Runner runner = new Runner(lottoPurchaseService, consoleInput, consoleOutput,
        profitRateCalculator);

    runner.run();
  }
}
