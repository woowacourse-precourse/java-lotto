package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private static final InputView inputView = new InputView();

    private static final OutputView outputView = new OutputView();

    private final LottoService lottoService;

    private Buyer buyer;

    private WinningNumbers winningNumbers;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void play() {
        buyLotto();
        inputWinningNumbers();
        printResult();
    }

    private void buyLotto() {
        buyer = new Buyer(printInputMoney());
        lottoService.buyLotto(buyer);
        printUserLottos(buyer);
    }

    private int printInputMoney() {
        outputView.inputMoney();
        return inputView.inputMoney();
    }

    private void inputWinningNumbers() {
        winningNumbers = new WinningNumbers(createWinningLotto(), createBonusNumber());
    }

    private List<Integer> createWinningLotto() {
        outputView.inputWinningLotto();
        return inputView.inputWinningLotto();
    }

    private int createBonusNumber() {
        outputView.inputBonusNumber();
        return inputView.inputBonusNumber();
    }


    private void printUserLottos(Buyer buyer) {
        for (Lotto lotto : buyer.getLottos()) {
            outputView.printLottoNumbers(lotto.getLotto());
        }
    }

    private void printResult() {
        lottoService.checkLottos(buyer, winningNumbers);
        outputView.winningStatistics();
        outputView.printRanksResult(buyer.getResult());
        outputView.printProfit(buyer.getProfit());
    }

}
