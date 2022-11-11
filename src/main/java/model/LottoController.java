package model;

import utils.Validator;
import view.InputView;
import view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Validator validator;
    private final LottoService lottoService;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
        validator = new Validator();
        lottoService = new LottoService();
    }

    public void start() {
        String input = inputView.inputMoney();
        validatePurchasingAmount(input);
        outputView.outputLotto(lottoService.issueLotto(Integer.parseInt(input)));

    }

    private void validatePurchasingAmount(String input) {
        validator.validateSize(input);
        validator.validateNumber(input);
        validator.validateMonetaryUnit(input);
    }

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.start();
    }
}
