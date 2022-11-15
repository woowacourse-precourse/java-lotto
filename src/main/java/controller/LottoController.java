package controller;

import domain.Lotto;
import repository.LottoRepository;
import repository.MoneyRepository;
import service.LottoService;
import service.MoneyService;
import service.Winner;
import view.InputView;
import view.OutputView;

import java.util.EnumMap;
import java.util.List;

public class LottoController {
    private final MoneyService moneyService;
    private final LottoService lottoService;

    public LottoController() {
        this.moneyService = new MoneyService(new MoneyRepository());
        this.lottoService = new LottoService(new LottoRepository());
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

    private void getWinners() {
        lottoService.saveWinners();
    }

    private void getRateOfReturn() {
        EnumMap<Winner, Integer> winners = lottoService.getWinners();
        moneyService.saveRateOfReturn(winners);
    }

}
