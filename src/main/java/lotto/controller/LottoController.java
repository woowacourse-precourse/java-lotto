package lotto.controller;

import lotto.domain.*;
import lotto.util.Statistics;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
        }
    }

    private void start() {

        LottoAmount lottoAmount = inputAmount();
        List<List<Integer>> lotto = buyLotto(lottoAmount);
        Lotto lottoNumber = inputLotto();
        BonusNumber bonusNumber = inputBonusNumber();
        WinningNumbers winningNumbers = resultNumbers(lottoNumber.getLottoNumber(), bonusNumber.getBonusNumber());
        Statistics statistics = summingUp();
        winningHistory(statistics, winningNumbers, lotto);
        calculator(statistics, lottoAmount);
    }

    private LottoAmount inputAmount() {
        int number = inputView.getPurchaseAmount();
        LottoAmount lottoAmount = new LottoAmount(number);
        outputView.printBuyLottoTicket(number);
        return lottoAmount;
    }

    private List<List<Integer>> buyLotto(LottoAmount lottoAmount) {
        List<List<Integer>> lottoNumbers = lottoAmount.buyLotto();
        outputView.printBuyLotto(lottoNumbers);
        return lottoNumbers;
    }

    private Lotto inputLotto() {
        List<Integer> numbers = inputView.getWinningNumbers();
        return new Lotto(numbers);
    }

    private BonusNumber inputBonusNumber() {
        int number = inputView.getBonusNumber();
        return new BonusNumber(number);
    }

    private WinningNumbers resultNumbers(List<Integer> lottoNumber, int bonusNumber) {
        return new WinningNumbers(lottoNumber, bonusNumber);
    }

    private Statistics summingUp() {
        return new Statistics();
    }

    private void winningHistory(Statistics statistics, WinningNumbers winningNumbers, List<List<Integer>> lottoNumbers) {
        statistics.makeTotalResult(winningNumbers, lottoNumbers);
        Map<Rank, Integer> totalResult = statistics.getTotalResult();
        outputView.printStatistics(totalResult);
    }

    private void calculator(Statistics statistics, LottoAmount lottoAmount) {
        double percentage = statistics.calculatorRevenue(lottoAmount.getPurchaseAmount());
        outputView.printPercentage(percentage);
    }
}
