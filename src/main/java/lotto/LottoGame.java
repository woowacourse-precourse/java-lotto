package lotto;

import controller.Controller;
import domain.LottoCompany;
import domain.User;
import view.ResultView;

import java.util.HashMap;

public class LottoGame {
    User user;

    Controller controller;
    ResultView resultView;
    LottoCompany lottoCompany;

    public void run() {
        gameSet();
        showSetResult();
        setLottoWinning();
        showResult();
    }

    private void gameSet() {
        controller = new Controller();
        user = new User();
        user.setInputUserMoney(controller.inputUserMoney());
        user.setTotalLotto(user.getInputUserMoney() / 1000);
        user.setTotalLottoNumbers(controller.createTotalLottoNumber(user.getTotalLotto()));
    }

    private void showSetResult() {
        resultView = new ResultView();
        resultView.resultCountLotto(user.getTotalLotto());
        resultView.resultTotalLotto(user.getTotalLottoNumbers());
    }

    private void setLottoWinning() {
        lottoCompany = new LottoCompany();
        lottoCompany.setLottoWinningNumbers(controller.inputLottoWinningNumbers());
        lottoCompany.setLottoWinningBonus(controller.inputBonusNumber());
    }

    private void showResult() {
        HashMap<String, Integer> result = controller.createWinningLotto(user.getTotalLottoNumbers(), lottoCompany.getLottoWinningNumbers(), lottoCompany.getLottoWinningBonus());
        resultView.resultLotto(result, user.getTotalLotto());
    }

}
