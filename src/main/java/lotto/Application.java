package lotto;

import lotto.domain.Lotto;
import lotto.domain.QuickPickGenerator;
import lotto.domain.WinningNumbersIncludingBonus;

import static lotto.view.Input.bonusNumberInput;
import static lotto.view.Input.purchasePriceInput;
import static lotto.view.Input.winningNumbersInput;
import static lotto.view.Output.printLotteries;
import static lotto.view.Output.printWinningStatistics;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            int purchasePrice = purchasePriceInput();
            printNewLine();
            List<Lotto> lotteries = QuickPickGenerator.quickPick(purchasePrice / 1_000);
            printLotteries(lotteries);

            Lotto winningNumbers = winningNumbersInput();
            printNewLine();
            int bonusNumber = bonusNumberInput();

            WinningNumbersIncludingBonus winnings = new WinningNumbersIncludingBonus(winningNumbers, bonusNumber);
            printNewLine();
            printWinningStatistics(lotteries, winnings);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printNewLine() {
        System.out.println();
    }
}
