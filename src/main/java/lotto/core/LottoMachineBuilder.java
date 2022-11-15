package lotto.core;

import lotto.models.Lotto;
import lotto.models.LottoResult;
import lotto.models.WinningLotto;
import lotto.views.Printer;
import lotto.views.Reader;

import java.util.List;

public class LottoMachineBuilder {

    private LottoFactory lottoFactory;
    private WinningLotto winningLotto;
    private List<Lotto> userLotteries;
    private int lottoPurchaseAmount;

    LottoMachineBuilder init(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
        return this;
    }

    LottoMachineBuilder purchaseLotteries() {
        Printer.showAskEnterThePurchaseAmountMessage();
        this.lottoPurchaseAmount = Reader.readUserLottoPurchaseAmount();

        Printer.showUserPurchasedLottoCount(lottoPurchaseAmount);
        this.userLotteries = lottoFactory.issueLottoNumbersByPurchaseAmount(lottoPurchaseAmount);
        Printer.showUserLottoNumbers(userLotteries);

        return this;
    }

    LottoMachineBuilder setWinningLotto() {
        Printer.showAskEnterTheWinningLottoNumberMessage();
        Lotto winningLotto = Reader.readUserLottoWinningNumber();

        Printer.showAskEnterTheWinningLottoBonusNumberMessage();
        int bonusNumber = Reader.readWinningLottoBonusNumberFromUser();

        this.winningLotto = new WinningLotto(winningLotto, bonusNumber);

        return this;
    }

    void showResult() {
        LottoManager lottoManager = new LottoManager(winningLotto, userLotteries);
        LottoResult userLotteriesResult = lottoManager.getUserLotteriesResult();
        double earningRate = userLotteriesResult.getEarningRate(lottoPurchaseAmount);

        Printer.showLotteriesResult(userLotteriesResult);
        Printer.showEarningRate(earningRate);
    }
}
