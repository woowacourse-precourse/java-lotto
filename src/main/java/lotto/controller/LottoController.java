package lotto.controller;

import static lotto.model.Bonus.validateDuplicates;
import static lotto.util.Constants.LOTTO_PRICE;
import static lotto.util.Formatter.formatWinningNumbersInput;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Player;
import lotto.model.Purchase;
import lotto.model.PlayerRanking;
import lotto.model.Rank;
import lotto.model.Statistics;
import lotto.model.Yield;
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
        OutputView.printAllPlayerNumbers(allPlayerNumbers);
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
        LottoResult result = new LottoResult(winningNumbers, bonusNumber, allPlayerNumbers);
        PlayerRanking playerRanking = new PlayerRanking(result.getMatches(), result.getBonusMatches());
        Rank.initializeRankCount();
        Statistics statistics = new Statistics(playerRanking.getPlayerRankings());
        OutputView.printStatistics(statistics.getStatistics());
    }

    private static void calculateYield() {
        Yield yield = new Yield(ticketNumber * LOTTO_PRICE);
        OutputView.printYield(yield.getYield());
    }

}
