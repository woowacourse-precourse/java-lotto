package lotto.controller;

import lotto.domain.Customer;
import lotto.domain.LottoMachine;
import lotto.dto.LottoDto;
import lotto.dto.LottoInformationDto;
import lotto.dto.LottoResultDto;
import lotto.dto.PurchaseAmountDto;
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
        Customer customer = buyLotto();
        LottoMachine lottoMachine = draw();
        check(customer, lottoMachine);
    }

    private Customer buyLotto() {
        PurchaseAmountDto purchaseAmountDto = inputView.inputPurchaseAmount();
        Customer customer = new Customer(purchaseAmountDto.getPurchaseAmount());
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
