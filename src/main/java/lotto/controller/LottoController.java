package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private LottoService lottoService =  new LottoService();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void startGame() {
        String userInputMoney = inputView.printUserInputMoney();
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
        outputView.printUserLotto(userLotto);
        createWinningNumber();
    }

    private void createWinningNumber() {
        String winningNumber = inputView.printUserInputWinningNumber();
        lottoService.createWinningLotto(winningNumber);
        getBonusNumber();
    }

    private void getBonusNumber() {
        String bonusNumber = inputView.printUserInputBonusNumber();
        lottoService.createBonusNumber(bonusNumber);
        compareLotto();
    }

    private void compareLotto() {
        List<Integer> compareResult = lottoService.compareLotto();
        showWinningResult(compareResult);
    }

    private void showWinningResult(List<Integer> result) {
        outputView.printWinningResult(result);
        getProfit();
    }

    private void getProfit() {
        String profit = lottoService.getProfit();
        OutputView.printProfit(profit);
    }


}
