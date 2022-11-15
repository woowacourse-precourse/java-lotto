package lotto.controller;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoGenerator;
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

    public LottoGameController() {
        ioManager = new IoManager();
        inputView = new ConsoleInputView();
        outputView = new ConsoleOutputView();
    }

    public void runGame() {
        try {
            runGameWithNoExceptionControl();
        } catch (Exception e) {
            outputView.printlnError(e.getMessage());
        }
    }

    private void runGameWithNoExceptionControl () {
        outputView.println(ioManager.PUT_PAYMENT_INPUT_ALERT);
        int amount = inputView.readInteger();

        Payment payment = new Payment(amount);


        LottoGenerator lottoGenerator = new LottoGenerator();

        List<Lotto> lottos = new ArrayList<>();
        outputView.println(ioManager.makePaymentAlert(payment));
        for(int i = 0; i < payment.getLottoCount(); i++) {
            Lotto tmpLotto = lottoGenerator.autoGenerate();
            outputView.println(tmpLotto.getNumbers());
            lottos.add(tmpLotto);
        }

        outputView.println(ioManager.PUT_WINNING_NUMBERS_INPUT_ALERT);
        List<Integer> numbers = inputView.readIntegers();
        Lotto winningLotto = lottoGenerator.generate(numbers);

        outputView.println(ioManager.PUT_BONUS_NUMBER_INPUT_ALERT);
        int bonusNumber = inputView.readInteger();

        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);

        List<LottoResult> lottoResults = new ArrayList<>();
        for(Lotto lotto : lottos) {
            int matchCount = winningNumbers.checkMatchCount(lotto);
            boolean doesBonusMatch = winningNumbers.checkBonusMatch(lotto);
            LottoResult lottoResult = LottoResult.getLottoResult(matchCount, doesBonusMatch);

            lottoResults.add(lottoResult);
        }

        LottoStatisticsGenerator statisticsGenerator = new LottoStatisticsGenerator();
        LottoStatistics lottoStatistics = statisticsGenerator.generate(lottoResults);

        outputView.println(ioManager.STATISTICS_LABEL);
        outputView.println(ioManager.DIVIDER);

        outputView.println(ioManager.makeLottoHistoryDescription(lottoStatistics));
        outputView.println(ioManager.makeReturnRateDescription(payment, lottoStatistics));
    }
}
