package lotto.controller;

import java.util.List;
import lotto.domain.CalculateFactory;
import lotto.domain.MakeLotteriesFactory;
import lotto.domain.WinningNumberService;
import lotto.model.Lotto;
import lotto.ui.BonusNumberView;
import lotto.ui.LotteryView;
import lotto.ui.PurchaseView;
import lotto.ui.ResultView;
import lotto.ui.WinningNumberView;

public class LottoController {

    private WinningNumberView winningNumberView;
    private BonusNumberView bonusNumberView;
    private MakeLotteriesFactory makeLotteriesFactory;
    private WinningNumberService winningNumberService;

    public void play(){
        purchase();
        makeLotteries();
        getNumbers();
        parseNumbers();
        calculate();
    }

    private void purchase(){
        PurchaseView purchaseView = new PurchaseView();
        purchaseView.makeView();
        System.out.println();

    }

    private void makeLotteries(){
        makeLotteriesFactory = new MakeLotteriesFactory(purchaseView.getPurchaseNumbers());
        List<Lotto> lotteries = makeLotteriesFactory.getLotteries();
        LotteryView lotteryView = new LotteryView(lotteries.size(), lotteries);
        lotteryView.makeView();
        System.out.println();
    }

    private void getNumbers(){
        getWinningNumbers();
        getBonusNumber();

    }

    private void getWinningNumbers(){
        winningNumberView = new WinningNumberView();
        winningNumberView.makeView();
        System.out.println();
    }

    private void getBonusNumber(){
        bonusNumberView = new BonusNumberView();
        bonusNumberView.makeView();
        System.out.println();
    }

    private void parseNumbers(){
        winningNumberService = new WinningNumberService();
        winningNumberService.parseWinningNumber(winningNumberView.getWinningNumbers());
        winningNumberService.parseBonusNumber(bonusNumberView.getBonusNumber());
    }

    private void calculate(){
        List<Lotto> lotteries = makeLotteriesFactory.getLotteries();
        CalculateFactory calculateFactory = new CalculateFactory(lotteries,
                winningNumberService.getLotteryWinningNumbers(), winningNumberService.getBonus());
        ResultView resultView = new ResultView(calculateFactory.getResult(), calculateFactory.getYield());
        resultView.makeView();
    }
}
