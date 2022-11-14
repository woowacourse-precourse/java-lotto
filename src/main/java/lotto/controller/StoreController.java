package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.Rank;
import lotto.model.Store;
import lotto.view.InputView;
import lotto.view.OutputView;

public class StoreController {
    private final Store store;
    private final InputView inputView;
    private final OutputView outputView;

    public StoreController() {
        this.store = new Store();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        try {
            order();
            setForLottoSale();
            judge();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void order() {
        String paidMoney = inputView.readUserPaidMoney();

        store.sellLottoToCustomer(paidMoney);
        outputView.showLottoCount(paidMoney);

        outputView.showLottos(store.getAllLottoByCustomer());
    }

    private void setForLottoSale() {
        String beforeWinningNumber = inputView.readWinningNumber();
        List<Integer> winningNumber = store.pickWinningNumber(beforeWinningNumber);

        String beforeBonusNumber = inputView.readBonusNumber();
        int bonusNumber = store.pickBonusNumber(winningNumber, beforeBonusNumber);

        store.pickWinningNumberWithBonusNumber(winningNumber, bonusNumber);
    }

    private void judge() {
        Map<Rank, Integer> customerRanks = store.judgeCustomerRanks();
        outputView.showCustomerRanks(customerRanks);

        float rateOfProfit = store.getRateOfProfitByCustomer(customerRanks);
        outputView.showRateOfProfit(rateOfProfit);
    }
}
