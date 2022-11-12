package lotto.controller;

import lotto.domain.Customer;
import lotto.dto.LottoDto;
import lotto.dto.LottoInformationDto;
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
        PurchaseAmountDto purchaseAmountDto = inputView.inputPurchaseAmount();
        Customer customer = new Customer(purchaseAmountDto.getPurchaseAmount());
        LottoInformationDto lottoInformationDto = lottoService.buy(customer);
        outputView.printLottoInformation(lottoInformationDto);

        LottoDto lottoDto = inputView.inputLottoNumbers();
    }
}
