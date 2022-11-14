package lotto.controller;

import static lotto.domain.Bonus.validateDuplicates;
import static lotto.domain.Purchase.LOTTO_PRICE;
import static lotto.util.Formatter.formatWinningNumbersInput;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Player;
import lotto.domain.Purchase;
import lotto.domain.Ranking;
import lotto.domain.Statistics;
import lotto.domain.Yield;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static List<List<Integer>> allPlayerNumbers;
    private static int ticketNumber;
    private static List<Integer> winningNumbers;
    private static int bonusNumber;

    public static void run() {
        try {
            purchaseLottoTickets();
            publishPlayerNumbers();
            determineWinningNumbersAndBonusNumber();
            aggregateStatisticResults();
            calculateYield();

        } catch (Exception error) {
            OutputView.printErrorMessage(error);
        }

    }

    private static void purchaseLottoTickets() {
        OutputView.printCashInput();
        Purchase budget = new Purchase(InputView.getInput());
        ticketNumber = budget.getTicketNumber();
        OutputView.printTicketNumber(ticketNumber);
    }

    private static void publishPlayerNumbers() {
        Player player = new Player(ticketNumber);
        allPlayerNumbers = new ArrayList<>(player.getAllPlayerNumbers());
        OutputView.printPlayerNumbers(allPlayerNumbers);
    }

    private static void determineWinningNumbersAndBonusNumber() {
        setWinningNumbers();
        setBonusNumber();
        validateDuplicates(winningNumbers, bonusNumber);
    }

    private static void setWinningNumbers() {
        OutputView.printWinningNumberInput();
        Lotto lotto = new Lotto(formatWinningNumbersInput(InputView.getInput()));
        winningNumbers = lotto.getWinningNumbers();
    }

    private static void setBonusNumber() {
        OutputView.printBonusNumberInput();
        Bonus bonus = new Bonus(InputView.getInput());
        bonusNumber = bonus.getBonusNumber();
    }

    private static void aggregateStatisticResults() {
        LottoResult result = new LottoResult(winningNumbers, allPlayerNumbers, bonusNumber);
        Ranking ranking = new Ranking(result.getMatches(), result.getBonusMatches());
        Statistics statistics = new Statistics(ranking.getRankings());
        OutputView.printStatistics(statistics.getRank());
    }

    private static void calculateYield() {
        Yield yield = new Yield(ticketNumber * LOTTO_PRICE);
        OutputView.printYield(yield.getYield());
    }

}
