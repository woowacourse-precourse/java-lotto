package lotto.controller;

import static lotto.view.OutputView.displayIncomeRatio;
import static lotto.view.OutputView.displayNumberOfTickets;
import static lotto.view.OutputView.displayStatistics;

import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void start() {
        try {
            process();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void process() {
        int price = InputView.getPrice();

        // 티켓 발행 내역 출력
        displayNumberOfTickets(lottoService.publishTickets(price));

        // 당첨 내역 출력
        displayStatistics(lottoService.getWinningStatistics(
            InputView.getNumbers(),
            InputView.getBonusNumber()));

        // 수익률 출력
        displayIncomeRatio(lottoService.getRateOfReturn(price));
    }
}
