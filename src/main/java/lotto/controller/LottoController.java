package lotto.controller;

import lotto.model.UserLottos;
import lotto.view.InputView;

public class LottoController {
    private Integer price;
    private UserLottos userLottos;

    public LottoController() {
        this.price = 0;
    }

    public void setPrice() {
        String inputString = InputView.buyLotto();
        ExceptionHandler.validateInputPriceOfString(inputString);
        this.price = Integer.parseInt(inputString);
    }

    public void setUserLottos() {
        this.userLottos = new UserLottos(this.price);
    }



    public Integer getPrice() {
        return this.price;
    }
}
