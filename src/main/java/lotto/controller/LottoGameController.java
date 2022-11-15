package lotto.controller;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoGenerator;
import lotto.model.lotto.LottoNumber;
import lotto.model.payment.Payment;
import lotto.model.statistics.LottoResult;
import lotto.model.statistics.LottoStatistics;
import lotto.model.statistics.LottoStatisticsGenerator;
import lotto.model.lotto.WinningNumbers;

import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameController {
    private final IoManager ioManager;

    private final ConsoleInputView inputView;
    private final ConsoleOutputView outputView;

    private final LottoGenerator lottoGenerator;
    private final LottoStatisticsGenerator statisticsGenerator;

    public LottoGameController() {
        ioManager = new IoManager();
        inputView = new ConsoleInputView();
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
        Payment payment = getAndProcessPaymentInput();
        List<Lotto> lottos = purchaseLottos(payment);
        WinningNumbers winningNumbers = getAndProcessWinningNumbersInput();
        List<LottoResult> lottoResults = checkLottos(lottos, winningNumbers);
        LottoStatistics lottoStatistics = statisticsGenerator.generate(lottoResults);

        printLottoStatistics(payment, lottoStatistics);
    }

    private Payment getAndProcessPaymentInput() {
        outputView.println(ioManager.PUT_PAYMENT_INPUT_ALERT);
        int amount = inputView.readInteger();
        return new Payment(amount);
    }

    private List<Lotto> purchaseLottos(Payment payment) {
        List<Lotto> lottos = new ArrayList<>();
        outputView.println(ioManager.makePaymentAlert(payment));
        for(int i = 0; i < payment.getLottoCount(); i++) {
            Lotto tmpLotto = lottoGenerator.autoGenerate();
            outputView.println(ioManager.lottoToString(tmpLotto));
            lottos.add(tmpLotto);
        }
        return lottos;
    }

    private WinningNumbers getAndProcessWinningNumbersInput() {
        outputView.println(ioManager.PUT_WINNING_NUMBERS_INPUT_ALERT);
        List<Integer> numbers = inputView.readIntegers();
        Lotto winningLotto = lottoGenerator.generate(numbers);

        outputView.println(ioManager.PUT_BONUS_NUMBER_INPUT_ALERT);
        LottoNumber bonusNumber = new LottoNumber(inputView.readInteger());

        return new WinningNumbers(winningLotto, bonusNumber);
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
        outputView.println(ioManager.STATISTICS_LABEL);
        outputView.println(ioManager.DIVIDER);
        outputView.println(ioManager.makeLottoHistoryDescription(lottoStatistics));
        outputView.println(ioManager.makeReturnRateDescription(payment, lottoStatistics));
    }
}