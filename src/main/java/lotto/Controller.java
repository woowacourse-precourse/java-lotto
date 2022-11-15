package lotto;

import camp.nextstep.edu.missionutils.Console;
import exception.InputParsingException;

import java.util.List;
import java.util.Map;

public class Controller {

    public Controller() {

        Viewer viewer = new Viewer();
        int purchaseAmount = viewer.setPurchaseAmount();

        Buyer buyer = new Buyer();
        List<Lotto> lottos = buyer.buyLotto(purchaseAmount);

        WinnerSelector winnerSelector = new WinnerSelector();
        List<List<Integer>> lottoResults = winnerSelector.compareLottos(lottos);

        RevenueCounter revenueCounter = new RevenueCounter();
        Map<WinningCase, List<Integer>> revenueResult = revenueCounter.convertToMoney(lottoResults);
        viewer.printRevenue(revenueResult);

        double revenueRate = revenueCounter.revenueRateCounter(lottoResults, purchaseAmount);
        viewer.printRevenueRate(revenueRate);


        }

}
