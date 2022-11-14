package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.view.View;

import java.util.List;

public class LottoController {
    private LottoService lottoService =  new LottoService();

    public void startGame() {
        String userInputMoney = View.printUserInputMoney();
        getTheNumberOfLotto(userInputMoney);
    }

    private void getTheNumberOfLotto(String userInputMoney) {
        Money userMoney = lottoService.getTheNumberOfLotto(userInputMoney);
        getUserLotto(userMoney.getTheNumberOfLotto());
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
        List<Integer> compareResult = lottoService.compareLotto();
        showWinningResult(compareResult);
    }

    private void showWinningResult(List<Integer> result) {
        View.printWinningResult(result);
        getProfit();
    }

    private void getProfit() {
        String profit = lottoService.getProfit();
        View.printProfit(profit);
    }


}
