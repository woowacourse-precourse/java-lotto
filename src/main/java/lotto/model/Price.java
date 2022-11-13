package lotto.model;

import lotto.controller.ExceptionHandler;
import lotto.view.InputView;

public class Price {

    private Integer price;

    public Price() {
        setPrice();
    }

    public void setPrice() {
        String inputString = InputView.buyLotto();
        ExceptionHandler.validateInputPriceOfString(inputString);
        this.price = Integer.parseInt(inputString);
    }

    public Integer getPrice() {
        return price;
    }
}
