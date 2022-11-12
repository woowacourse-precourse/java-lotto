package lotto.controller;

import lotto.Lotto;
import lotto.service.LottoService;
import lotto.view.View;

import java.util.List;

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
        Integer numberOfLotto = lottoService.getTheNumberOfLotto(userInputMoney);
        getUserLotto(numberOfLotto);
    }

    private void getUserLotto(Integer numberOfLotto) {
        List<Lotto> userLotto = lottoService.createUserLotto(numberOfLotto);
        showUserLotto(userLotto);
    }

    private void showUserLotto(List<Lotto> userLotto) {
        View.printUserLotto(userLotto);
        createWinningNumber();
    }

    private void createWinningNumber() {
        String winningNumber = View.printUserInputWinningNumber();
        lottoService.createWinningLotto(winningNumber);
    }


}
