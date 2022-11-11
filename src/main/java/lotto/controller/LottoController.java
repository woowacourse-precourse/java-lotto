package lotto.controller;

import lotto.service.LottoService;
import lotto.view.View;

public class LottoController {
    private LottoService lottoService;
    public LottoController() {
        this.lottoService = new LottoService();
    }
    public void startGame() {
        String userInputMoney = View.printUserInputMoney();
        getTheNumberOfLotto(userInputMoney);
    }

    private void getTheNumberOfLotto(String userInputMoney) {
        Integer numberOfLotto = LottoService.getTheNumberOfLotto(userInputMoney);
    }
}
