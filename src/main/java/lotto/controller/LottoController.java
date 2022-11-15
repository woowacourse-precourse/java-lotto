package lotto.controller;

import lotto.domain.*;
import lotto.domain.strategy.InputLottoGenerateStrategy;
import lotto.domain.strategy.RandomLottoGenerateStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.printer.InputPrinter;

import java.util.List;
import java.util.Map;

public class LottoController {
    Money userMoney;
    List<Lotto> userMultipleLotto;
    WinningLotto winningLotto;

    public void runLottoMachine() {
        try{
            userMoney = Money.from(InputView.inputMoneyByUser());
            userMultipleLotto = createUserLottoGenerator().generateMultipleLotto(userMoney.getCountOfLotto());
            OutputView.printUserLottos(userMultipleLotto);
            winningLotto = createWinningLotto();
            showUserWinningStatistics();
        } catch (IllegalArgumentException e){
            OutputView.printErrorMessage(e);
        }
    }

    private LottoGenerator createUserLottoGenerator() {
        return LottoGenerator.from(new RandomLottoGenerateStrategy());
    }

    private LottoGenerator createWinningLottoGenerator() {
        return LottoGenerator.from(new InputLottoGenerateStrategy());
    }

    private WinningLotto createWinningLotto() {
        InputPrinter.printInputWinningNumbersMessage();
        Lotto winningNumber = createWinningLottoGenerator().generate();
        String bonusNumber = (InputView.inputBonusNumber());
        return WinningLotto.of(winningNumber, bonusNumber);
    }

    private void showUserWinningStatistics() {
        Map<Rank, Integer> userLottoScore = winningLotto.getUserLottoScore(userMultipleLotto);
        String profitRate = userMoney.calculateProfitRate(getTotalWinningPrize(userLottoScore));
        OutputView.printWinningStatistics(userLottoScore, profitRate);
    }

    private int getTotalWinningPrize(Map<Rank, Integer> userLottoScore) {
        int totalWinningPrize = 0;
        for (int index = 1; index < Rank.values().length; index++) {
            Rank rank = Rank.values()[index];
            totalWinningPrize += userLottoScore.get(rank) * rank.getPrizeMoney();
        }
        return totalWinningPrize;
    }
}