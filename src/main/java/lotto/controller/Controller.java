package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public Controller() {
        inputView = new InputView();
        outputView = new OutputView();
        lottoService = new LottoService();
    }

    public void play() {
        try {
            Long purchaserId = lottoService.generatePurchaser(inputView.inputMoney());
            lottoService.buyLotto(purchaserId);
            printLottos(lottoService.findPurchaserLottos(purchaserId));
            List<Integer> winningLottoNumbers = lottoService.generateWinningLottoNumbers(inputView.inputWinningLottoNumbers());
            int bonusNumber = lottoService.generateBonusNumber(inputView.inputBonusNumber());
            lottoService.matchLottos(purchaserId, winningLottoNumbers, bonusNumber);
            String rateReturn = lottoService.computeRateReturn(purchaserId);
            printWinningStatistics(purchaserId, rateReturn);
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return;
        }
    }

    private void printWinningStatistics(Long purchaserId, String rateReturn) {
        outputView.printWinningHistory(lottoService.findPurchaserWinningHistory(purchaserId));
        outputView.printRateReturn(rateReturn);
    }

    private void printLottos(List<List<Integer>> purchaserLottos) {
        outputView.printLottoQuantity(purchaserLottos.size());
        for (List<Integer> purchaserLotto : purchaserLottos) {
            outputView.printLotto(purchaserLotto);
        }
    }

}