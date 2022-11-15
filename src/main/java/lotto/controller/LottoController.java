package lotto.controller;

import static lotto.constant.LottoConstant.AMOUNT_LIMIT;

import java.util.List;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        int amount = generateByAmount();
        checkWinning();
        calculateRate(amount);
    }

    private int generateByAmount() {
        outputView.printWithLine(OutputView.INPUT_AMOUNT);
        int amount = inputView.inputAmount();

        lottoService.generateByAmount(amount);

        outputView.printWithLine((amount / AMOUNT_LIMIT) + OutputView.BUY_COMPLETE);
        outputView.print(lottoService.showLottos());
        return amount;
    }

    private void checkWinning() {
        outputView.printWithLine(OutputView.INPUT_WINNING_NUMBERS);
        List<Integer> winningNumbers = inputView.inputWinningNumbers();

        outputView.printWithLine(OutputView.INPUT_BONUS_NUMBER);
        int bonusNumber = inputView.inputBonusNumber(winningNumbers);

        result(winningNumbers, bonusNumber);
    }

    private void calculateRate(int amount) {
        outputView.printWithLine(lottoService.calculateRate(amount));
    }

    private void result(List<Integer> winningNumbers, int bonusNumber) {
        outputView.print(OutputView.RESULT + lottoService.checkWinning(winningNumbers, bonusNumber));
    }

}
