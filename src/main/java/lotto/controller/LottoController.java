package lotto.controller;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.UserLottos;
import lotto.view.InputView;

public class LottoController {
    private Integer price;
    private UserLottos userLottos;
    private Lotto winningNum;
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

    public void setWinningNum() {
        String winningNumString = InputView.inputWinningNum();
        ExceptionHandler.validateWinningNum(winningNumString);
        this.winningNum = new Lotto(Arrays
                .stream(winningNumString.split(","))
                .map(Integer::parseInt).collect(
                Collectors.toList()));
    }




    public Integer getPrice() {
        return this.price;
    }

    public Lotto getWinningNum() {
        return winningNum;
    }
}
