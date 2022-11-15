package lotto;

import controller.Controller;
import domain.LottoCompany;
import domain.Result;
import domain.User;
import view.ResultView;

import java.util.HashMap;

public class LottoGame {
    User user;

    Controller controller;
    ResultView resultView;
    LottoCompany lottoCompany;
    Result result;

    public void run() {
        gameSet();
        showSetResult();
        setLottoWinning();
        showResult();
    }

    private void gameSet() {
        controller = new Controller();
        int userMoney = controller.inputMoney();
        int totalCount = userMoney / 1000;
        user = new User(userMoney, totalCount, controller.createTotalNumbers(totalCount));
    }

    private void showSetResult() {
        resultView = new ResultView();
        resultView.resultCountLotto(user.getTotalCount());
        resultView.resultTotalCount(user.getTotalNumbers());
    }

    private void setLottoWinning() {
        lottoCompany = new LottoCompany(controller.inputWinningNumbers(), controller.inputBonusNumber());
    }

    private void showResult() {
        result = new Result(controller.createWinningResult(user.getTotalNumbers(), lottoCompany.getWinningNumbers(), lottoCompany.getWinningBonus()));
        resultView.resultLotto(result.getWinningResult(), user.getInputMoney());
    }

}
