package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoStats;
import lotto.domain.Purchase;
import lotto.view.InputView;
import lotto.view.OutputView;

public class FrontController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Purchase purchase;
    private final LottoStats lottoStats;
    public FrontController(InputView inputView, OutputView outputView, Purchase purchase, LottoStats lottoStats) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.purchase = purchase;
        this.lottoStats = lottoStats;
    }
    public void run(){
        try {
            outputView.startProgram();
            purchaseLotto();
            printLotto();
            calculationStats();
            printStatsResult();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public void purchaseLotto(){
        purchase.lotto(inputView.inputCost());
    }
    public void printLotto(){
        outputView.purchaseLottoResultPrint(purchase.getMyLotto());
    }
    private WinningAndBonus decisionWinningNumberAndBonus(){
        Lotto winningNumber = inputView.inputWinningNumber();
        Integer bonus = inputView.inputBonusNumber(winningNumber);
        return new WinningAndBonus(winningNumber,bonus);
    }
    public void calculationStats(){
        WinningAndBonus winningAndBonus = decisionWinningNumberAndBonus();
        lottoStats.calculationStats(purchase, winningAndBonus.lotto,winningAndBonus.bonus);
    }
    public void printStatsResult(){
        outputView.StatsResultPrint(lottoStats.statistics(), lottoStats.getEarning());
    }

    static class WinningAndBonus{
        Lotto lotto;
        Integer bonus;
        public WinningAndBonus(Lotto lotto, Integer bonus) {
            this.lotto = lotto;
            this.bonus = bonus;
        }
    }
}
