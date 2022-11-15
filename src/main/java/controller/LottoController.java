package controller;

import domain.Lotto;
import service.LottoService;
import service.MoneyService;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoController {
    private final MoneyService moneyService;
    private final LottoService lottoService;

    public LottoController() {
        this.moneyService = new MoneyService();
        this.lottoService = new LottoService();
    }

    private void getPurchaseAmount() {
        String purchaseAmount = InputView.receivePurchaseAmount();
        moneyService.savePurchaseAmount(purchaseAmount);
    }

    private void publishLotto() {
        int purchaseAmount = moneyService.getPurchaseAmount();
        lottoService.publishLotto(purchaseAmount);
    }

    private void getPublishedLotto() {
        List<Lotto> lotto = lottoService.getPublishedLotto();
        OutputView.noticePublishedLotto(lotto);
    }

    private void getWinningNumbers() {
        String numbers = InputView.receiveWinningNumbers();
        lottoService.saveWinningNumbers(numbers);
    }

    private void getBonusNumber() {
        String number = InputView.receiveBonusNumber();
        lottoService.saveBonusNumber(number);
    }
}
