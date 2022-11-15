package lotto.controller;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoGenerator;
import lotto.model.lotto.LottoNumber;
import lotto.model.payment.Payment;
import lotto.model.statistics.LottoResult;
import lotto.model.statistics.LottoStatistics;
import lotto.model.statistics.LottoStatisticsGenerator;
import lotto.model.lotto.WinningNumbers;

import lotto.view.ConsoleOutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameController {
    private final OutputManager outputManager;

    private final InputManager inputManager;
    private final ConsoleOutputView outputView;

    private final LottoGenerator lottoGenerator;
    private final LottoStatisticsGenerator statisticsGenerator;

    public LottoGameController() {
        outputManager = new OutputManager();
        inputManager = new InputManager();
        outputView = new ConsoleOutputView();
        lottoGenerator = new LottoGenerator();
        statisticsGenerator = new LottoStatisticsGenerator();
    }

    public void runGame() {
        try {
            runGameWithNoExceptionControl();
        } catch (Exception e) {
            outputView.printlnError(e.getMessage());
        }
    }

    private void runGameWithNoExceptionControl () {
        Payment payment = inputPayment();
        List<Lotto> lottos = purchaseLottos(payment);

        WinningNumbers winningNumbers = inputWinningNumbers();

        List<LottoResult> lottoResults = checkLottos(lottos, winningNumbers);
        LottoStatistics lottoStatistics = statisticsGenerator.generate(lottoResults);

        printLottoStatistics(payment, lottoStatistics);
    }

    private Payment inputPayment() {
        outputView.println(outputManager.PUT_PAYMENT_INPUT_ALERT);
        return inputManager.getAndProcessPaymentInput();
    }

    private WinningNumbers inputWinningNumbers() {
        outputView.println(outputManager.PUT_BONUS_NUMBER_INPUT_ALERT);
        LottoNumber bonusNumber = inputManager.getAndProcessLottoNumberInput();

        outputView.println(outputManager.PUT_WINNING_NUMBERS_INPUT_ALERT);
        Lotto winningLotto = inputManager.getAndProcessLottoInput();

        return new WinningNumbers(winningLotto, bonusNumber);
    }

    private List<Lotto> purchaseLottos(Payment payment) {
        List<Lotto> lottos = new ArrayList<>();
        outputView.println(outputManager.printPaymentAlert(payment));
        for(int i = 0; i < payment.getLottoCount(); i++) {
            Lotto tmpLotto = lottoGenerator.autoGenerate();
            outputView.println(outputManager.lottoToString(tmpLotto));
            lottos.add(tmpLotto);
        }
        return lottos;
    }

    private List<LottoResult> checkLottos(List<Lotto> lottos, WinningNumbers winningNumbers) {
        List<LottoResult> lottoResults = new ArrayList<>();
        for(Lotto lotto : lottos) {
            int matchCount = winningNumbers.checkMatchCount(lotto);
            boolean doesBonusMatch = winningNumbers.checkBonusMatch(lotto);
            LottoResult lottoResult = LottoResult.getLottoResult(matchCount, doesBonusMatch);

            lottoResults.add(lottoResult);
        }
        return lottoResults;
    }

    private void printLottoStatistics(Payment payment, LottoStatistics lottoStatistics) {
        outputView.println(outputManager.STATISTICS_LABEL);
        outputView.println(outputManager.DIVIDER);
        outputView.println(outputManager.makeLottoHistoryDescription(lottoStatistics));
        outputView.println(outputManager.makeReturnRateDescription(payment, lottoStatistics));
    }
}