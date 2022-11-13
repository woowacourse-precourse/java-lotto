package lotto.controller;

import java.util.List;

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
        try{
            start();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public void start() {
        OutputView.printInputAmount();
        Integer paidAmount = InputView.inputPaidAmount();

        LottoTicketDTO lottoTicketDTO = lottoService.issueLottoByPaidAmount(paidAmount);
        OutputView.printPaidLotto(paidAmount, lottoTicketDTO);

        OutputView.printInputWinningNumber();
        List<Integer> winningLottoNumber = InputView.inputWinningNumber();

        OutputView.printInputBonusNumber();
        Integer bonusLottoNumber = InputView.inputBonusNumber();
    }
}
