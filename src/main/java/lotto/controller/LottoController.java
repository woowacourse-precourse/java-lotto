package lotto.controller;

import java.util.List;
import lotto.dto.LottoStatsDTO;
import lotto.dto.LottoTicketDTO;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void start() {
        purchaseLotto();
        announceLottoNumber();
        prepareLotto();
    }

    private void purchaseLotto() {
        OutputView.printInputAmount();
        Integer paidAmount = InputView.inputPaidAmount();

        LottoTicketDTO lottoTicketDTO = lottoService.purchaseLottoByPaidAmount(paidAmount);
        OutputView.printPaidLotto(paidAmount, lottoTicketDTO);
    }

    private void announceLottoNumber() {
        OutputView.printInputWinningNumber();
        List<Integer> winningLottoNumber = InputView.inputWinningNumber();

        OutputView.printInputBonusNumber();
        Integer bonusLottoNumber = InputView.inputBonusNumber();

        lottoService.announceWinningLottoNumber(winningLottoNumber, bonusLottoNumber);
    }

    private void prepareLotto() {
        LottoStatsDTO lottoStatsDTO = lottoService.compareLottoNumbers();
        OutputView.printStatsMessage(lottoStatsDTO);
    }
}
