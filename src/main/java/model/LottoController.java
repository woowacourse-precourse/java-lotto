package model;

import utils.Validator;
import view.InputView;

public class LottoController {
    private final InputView inputView;
    private final Validator validator;

    public LottoController() {
        this.inputView = new InputView();
        this.validator = new Validator();
    }

    public void start() {
        String input = inputView.inputMoney();
        validatePurchasingAmount(input);

    }

    private void validatePurchasingAmount(String input) {
        validator.validateSize(input);
        validator.validateNumber(input);
        validator.validateMonetaryUnit(input);
    }

}
