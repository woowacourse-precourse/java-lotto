package lotto.controller;

import static lotto.domain.Purchase.LOTTO_PRICE;
import static lotto.util.Validation.validateDuplicates;

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
import lotto.util.Formatter;
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

            // 로또 결과 계산
            LottoResult result = new LottoResult(winningNumbers, allPlayerNumbers, bonusNumber);
            List<Integer> matches = result.getMatches(); // [3, 1, 5, 5, 3]
            List<Boolean> bonusMatches = result.getBonusMatches(); // [true, false, true, false, false]

            // 로또 순위 계산
            Ranking ranking = new Ranking(matches, bonusMatches); // [FIFTH, NONE, SECOND, THIRD, FIFTH]
            Statistics statistics = new Statistics(ranking.getRankings());

            OutputView.printStatistics(statistics.getRank());

            Yield yield = new Yield(ticketNumber * LOTTO_PRICE);
            OutputView.printYield(yield.getYield());

        } catch (Exception error) {
            OutputView.printErrorMessage(error);
        }

    }

    private static void setWinningNumbers() {
        OutputView.printWinningNumberInput();
        Lotto lotto = new Lotto(Formatter.formatWinningNumbersInput(InputView.getInput()));
        winningNumbers = lotto.get();
    }

    private static void setBonusNumber() {
        OutputView.printBonusNumberInput();
        Bonus bonus = new Bonus(InputView.getInput());
        bonusNumber = bonus.get();
    }

    private static void determineWinningNumbersAndBonusNumber() {
        setWinningNumbers();
        setBonusNumber();
        validateDuplicates(winningNumbers, bonusNumber);
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
}
