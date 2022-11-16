package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void start() {
        try {
            int price = InputView.getPrice();

            OutputView.displayNumberOfTickets(
                lottoService.publishTickets(price)
            );

            OutputView.displayStatistics(
                lottoService.getWinningStatistics(
                    InputView.getNumbers(),
                    InputView.getBonusNumber()));

            OutputView.displayIncomeRatio(
                lottoService.getRateOfReturn(price)
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
