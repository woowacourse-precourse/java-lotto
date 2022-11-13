package lotto.controller;

import lotto.constants.message.ExceptionMessage;
import lotto.service.LottoService;
import lotto.views.InputView;

public class LottoController {
    public static final String ONLY_NUMBER = "^[0-9]*$";

    private final LottoService lottoService = new LottoService();
    private final InputView inputView = new InputView();

    public void startLottoApplication() {
        String inputPrice = inputView.inputPrice();
        validateInputPrice(inputPrice);
        lottoService.buyLottos(Integer.parseInt(inputPrice));
    }

    private void validateInputPrice(String inputPrice) {
        if (!inputPrice.matches(ONLY_NUMBER)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.NON_NUMERIC_INPUT);
        }
    }

}