package lotto;

import static lotto.Input.bonusNumberInput;
import static lotto.Input.purchasePriceInput;
import static lotto.Input.winningNumbersInput;
import static lotto.Output.printLotteries;
import static lotto.Output.printWinningStatistics;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchasePrice = purchasePriceInput();
        int purchaseCount = purchasePrice / 1000;

        System.out.println();

        List<Lotto> lotteries = QuickPickGenerator.quickPick(purchaseCount);
        printLotteries(lotteries);

        System.out.println();

        Lotto winningNumbers = new Lotto(winningNumbersInput());
        System.out.println();
        int bonusNumber = bonusNumberInput();

        WinningNumbersIncludingBonus winnings = new WinningNumbersIncludingBonus(winningNumbers, bonusNumber);

        printWinningStatistics(lotteries, winnings);
    }

}
