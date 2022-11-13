package lotto.controller;

import lotto.Lotto;
import lotto.service.LottoService;
import lotto.view.View;

import java.util.List;
import java.util.Map;

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
        getBonusNumber();
    }

    private void getBonusNumber() {
        String bonusNumber = View.printUserInputBonusNumber();
        lottoService.createBonusNumber(bonusNumber);
        compareLotto();
    }

    private void compareLotto() {
        Map<Integer,Integer> result = lottoService.compareLotto();
        View.printWinningResult(result);
    }


}
