package lotto;

import controller.Result;
import controller.Service;
import domain.LottoCompany;
import domain.User;
import view.ResultView;

import java.util.HashMap;

public class LottoGame {
    User user;
    Service service;
    ResultView resultView;
    LottoCompany lottoCompany;

    public void run(){
        gameSet();
        showSetResult();
        setLottoWinning();
        showResult();
    }
    private void gameSet(){
        service = new Service();
        user = new User();
        user.setInputUserMoney(service.inputUserMoney());
        user.setTotalLotto(user.getInputUserMoney()/1000);
        user.setTotalLottoNumbers(service.createTotalLottoNumber(user.getTotalLotto()));
    }
    private void showSetResult(){
        resultView = new ResultView();
        resultView.resultCountLotto(user.getTotalLotto());
        resultView.resultTotalLotto(user.getTotalLottoNumbers());
    }

    private void setLottoWinning(){
        lottoCompany = new LottoCompany();
        lottoCompany.setLottoWinningNumbers(service.inputLottoWinningNumbers());
        lottoCompany.setLottoWinningBonus(service.inputBonusNumber());
    }

    private void showResult(){
        HashMap<String, Integer> result = service.createWinningLotto(user.getTotalLottoNumbers(), lottoCompany.getLottoWinningNumbers(), lottoCompany.getLottoWinningBonus());
        resultView.resultLotto(result, user.getTotalLotto());
    }

}
