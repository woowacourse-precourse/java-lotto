package lotto.application;

import lotto.application.config.LottoApplicationConfig;
import lotto.controller.LottoController;
import lotto.controller.request.JudgeWinningRequest;
import lotto.controller.request.LottoPurchaseRequest;
import lotto.controller.result.LottoPurchaseResult;
import lotto.controller.result.WinningResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.money.Money;
import lotto.domain.winningnumber.WinningNumber;
import lotto.infra.log.Logger;
import lotto.step.PurchaseLotto;
import lotto.step.Step;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplicationContext {

    private final Logger log = new Logger();

    private final LottoController lottoController;

    private Step step;

    private WinningNumber winningNumber;
    private Money payment;

    private WinningResult winningResult;
    private LottoPurchaseResult purchaseResult;

    public LottoApplicationContext(final LottoApplicationConfig config) {
        this.lottoController = config.lottoController();
        this.step = new PurchaseLotto(this);
    }

    public boolean finish() {
        return !step.executable();
    }

    public void progress() {
        try {
            step.execute();
            step = step.next();
        } catch (RuntimeException e) {
            log.error(e.getMessage(), e.getClass());
        }
    }

    public void purchaseLotto() {
        this.payment = InputView.inputPurchaseMoney();

        this.purchaseResult = lottoController.purchaseLotto(new LottoPurchaseRequest(payment));
    }

    public void showPurchasedLotto() {
        OutputView.printPurchaseLottoCount(purchaseResult);
    }

    public void inputWinnerNumber() {
        Lotto winningLotto = InputView.inputWinningLottoNumber();
        int bonusNumber = InputView.inputBonusNumber();

        this.winningNumber = new WinningNumber(winningLotto, bonusNumber);
    }

    public void calculateWin() {
        JudgeWinningRequest request = new JudgeWinningRequest(
                payment,
                purchaseResult.getLottos(),
                winningNumber
        );

        winningResult = lottoController.judgeWinning(request);
    }

    public void showStatistics() {
        OutputView.printStatistic(winningResult);
    }
}
