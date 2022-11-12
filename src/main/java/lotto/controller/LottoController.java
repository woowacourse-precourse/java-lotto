package lotto.controller;

import lotto.view.InputView;

public class LottoController {
    private Integer price;

    public LottoController() {
        this.price = 0;
    }

    public void setPrice() {
        String inputString = InputView.buyLotto();
        ExceptionHandler.validateInputPriceOfString(inputString);
        this.price = Integer.parseInt(inputString);
    }

    public Integer getPrice() {
        return this.price;
    }
}
