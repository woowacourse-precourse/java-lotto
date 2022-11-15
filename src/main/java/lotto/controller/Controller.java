package lotto.controller;

import lotto.domain.Player;
import lotto.domain.WinningsCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    public void runLottoGame() {
        try {
            Player player = new Player(inputView.inputPayment());
            printIssuedLottoInformation(player);

            WinningsCalculator computer = new WinningsCalculator(
                    inputView.inputWinningNumbers(),
                    inputView.inputBonusNumber()
            );
            printWinningInformation(player, computer);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    void printIssuedLottoInformation(Player player) {
        outputView.printLottoCountMessage(player.getLottoCount());
        outputView.printLottoNumbers(player.getLottoPapers());
    }

    void printWinningInformation(Player player, WinningsCalculator computer) {
        Map<String, Integer> rankingCounts = computer.countLottoRankings(player.getLottoPapers());
        outputView.printStatisticsMessage();
        outputView.printWinningCounts(rankingCounts);

        long totalWinnings = computer.calculateTotalWinnings(rankingCounts);
        double rateOfReturn = computer.calculateRateOfReturn(
                totalWinnings,
                player.getPayment()
        );
        outputView.printRateOfReturn(rateOfReturn);
    }
}