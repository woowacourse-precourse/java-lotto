package lotto.controller;

import static lotto.service.LottoService.*;

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

        LottoTicketDTO lottoTicketDTO = issueLottoByPaidAmount(paidAmount);
        OutputView.printPaidLotto(paidAmount, lottoTicketDTO);
    }
}
