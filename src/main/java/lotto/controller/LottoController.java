package lotto.controller;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.Price;
import lotto.model.UserLottos;
import lotto.view.InputView;

public class LottoController {
    private Price price;
    private UserLottos userLottos;
    private Lotto winningNum;

    public LottoController() {
    }



    public void setWinningNum() {
        String winningNumString = InputView.inputWinningNum();
        ExceptionHandler.validateWinningNum(winningNumString);
        this.winningNum = new Lotto(Arrays
                .stream(winningNumString.split(","))
                .map(Integer::parseInt).collect(
                Collectors.toList()));
    }


    public Lotto getWinningNum() {
        return winningNum;
    }
}
