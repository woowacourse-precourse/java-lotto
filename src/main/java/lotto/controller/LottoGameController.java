package lotto.controller;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoGenerator;
import lotto.model.lotto.LottoNumber;
import lotto.model.lotto.WinningNumbers;
import lotto.model.payment.Payment;
import lotto.model.statistics.LottoResult;
import lotto.model.statistics.LottoStatistics;
import lotto.model.statistics.LottoStatisticsGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoGameController {
    private final InputManager inputManager;
    private final OutputManager outputManager;

    private final LottoGenerator lottoGenerator;
    private final LottoStatisticsGenerator statisticsGenerator;

    public LottoGameController() {
        outputManager = new OutputManager();
        inputManager = new InputManager();
        lottoGenerator = new LottoGenerator();
        statisticsGenerator = new LottoStatisticsGenerator();
    }

    public void runGame() {
        try {
            runGameWithNoExceptionControl();
        } catch (Exception e) {
            outputManager.printError(e.getMessage());
        }
    }

    private void runGameWithNoExceptionControl () {
        Payment payment = inputPayment();
        List<Lotto> lottos = purchaseLottos(payment);

        WinningNumbers winningNumbers = inputWinningNumbers();

        List<LottoResult> lottoResults = checkLottos(lottos, winningNumbers);
        LottoStatistics lottoStatistics = statisticsGenerator.generate(lottoResults);
        outputManager.printLottoStatistics(payment, lottoStatistics);
    }

    private Payment inputPayment() {
        outputManager.printPaymentInputAlert();
        return inputManager.getAndProcessPaymentInput();
    }

    private WinningNumbers inputWinningNumbers() {
        outputManager.printWinningLottoInputAlert();
        Lotto winningLotto = inputManager.getAndProcessLottoInput();

        outputManager.printBonusNumberInputAlert();
        LottoNumber bonusNumber = inputManager.getAndProcessLottoNumberInput();

        return new WinningNumbers(winningLotto, bonusNumber);
    }

    private List<Lotto> purchaseLottos(Payment payment) {
        outputManager.printPaymentAlert(payment);

        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < payment.getLottoCount(); i++) {
            Lotto tmpLotto = lottoGenerator.autoGenerate();
            outputManager.printLotto(tmpLotto);
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
}