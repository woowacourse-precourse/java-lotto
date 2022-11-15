package lotto.controller;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map.Entry;
import lotto.Constants;
import lotto.domain.Lotto;
import lotto.domain.WinningResult;
import lotto.service.ResultService;
import lotto.service.UserLottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class UserLottoController {
    private static UserLottoController instance;
    private static UserLottoService userLottoService;
    private static ResultService resultService;

    private UserLottoController() {
        userLottoService = UserLottoService.getInstance();
        resultService = ResultService.getInstance();
    }

    public static UserLottoController getInstance() {
        if (instance == null) {
            instance = new UserLottoController();
        }
        return instance;
    }

    public String enterPurchaseAmount() throws IllegalArgumentException {
        OutputView.printAskPurchaseAmount();
        String purchaseAmount = InputView.input();
        userLottoService.validate(purchaseAmount);
        return purchaseAmount;
    }

    public void issueLotteries(long issueCnt) {
        OutputView.printIssueCount(issueCnt);
        userLottoService.issueLotto(issueCnt);
        OutputView.printIssuedLotteries(userLottoService.getLotteries());
    }

    public List<Lotto> getIssuedLotteries() {
        return userLottoService.getLotteries();
    }

    public void calculateEarningRate() {
        long earn = 0;
        for (Entry<WinningResult, Integer> entry : resultService.getLottoResultCount().entrySet()) {
            earn = (long) entry.getKey().getPrizeMoney() * entry.getValue();
        }
        double rate = ((double) earn * 100) /
                (userLottoService.getLotteries().size() * Constants.MINIMUM_PURCHASE_AMOUNT);
        rate = Math.round(rate * 10) / 10f;
        OutputView.printEarningRate(NumberFormat.getInstance().format(rate));
    }
}
