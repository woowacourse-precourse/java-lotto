package lotto.controller;

import lotto.view.InputView;

public class Controller {
    private final InputView inputView = new InputView();
    private final TypeValidation typeValidator = new TypeValidation();
    public void execute(){
        String purchaseAmount = inputView.getPurchaseAmount();
        typeValidator.checkNumericValue(purchaseAmount);
    }

}
