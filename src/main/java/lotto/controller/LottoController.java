package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.User;
import lotto.service.LottoService;
import lotto.utils.InputConverter;
import lotto.utils.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        User user = new User(purchaseAmount);
        OutputView.printLottoInformation(user.getLottos());
    }

    private Integer getPurchaseAmount() {
        InputView.printInputMoneyMessage();
        Integer purchaseAmount = InputConverter.toInteger(Console.readLine());
        Validator.validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }
}
