package lotto.controller;

import lotto.domain.Customer;
import lotto.domain.LottoMachine;
import lotto.dto.BuyAmountDto;
import lotto.dto.LottoDto;
import lotto.dto.LottoInformationDto;
import lotto.dto.LottoResultDto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final InputView inputView = InputView.INSTANCE;
    private static final OutputView outputView = OutputView.INSTANCE;

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        try {
            lotto();
        } catch (RuntimeException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private void lotto() {
        Customer customer = buyLotto();
        LottoMachine lottoMachine = draw();
        check(customer, lottoMachine);
    }

    private Customer buyLotto() {
        BuyAmountDto BuyAmountDto = inputView.inputBuyAmount();
        Customer customer = new Customer(BuyAmountDto.getAmount());
        LottoInformationDto lottoInformationDto = lottoService.buy(customer);
        outputView.printLottoInformation(lottoInformationDto);
        return customer;
    }

    private LottoMachine draw() {
        LottoDto lottoDto = inputView.inputLottoNumbers();
        return lottoService.draw(lottoDto);
    }

    private void check(Customer customer, LottoMachine lottoMachine) {
        LottoResultDto lottoResultDto = lottoService.check(customer, lottoMachine);
        outputView.printLottoResult(lottoResultDto);
    }
}
