package lotto.controller;

import lotto.Utils.InputValid;
import lotto.Utils.RandomUtil;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private User user;
    private Lotto lotto;

    public LottoController() {
        user=new User();
    }

    public void startLotto(){
        inIt();

        OutputView.printGameCount(user.getUserGameCnt());
        randomNumbersController();

        lotto=new Lotto(InputView.getLottoNumber());
        lotto.setBonusNumber(InputView.getBonusNumber(lotto.getNumbers()));
    }

    private void inIt(){
        user.setUserPrice(InputView.getUserPriceNumber());
    }

    private void randomNumbersController(){
        List<List<Integer>> randomNumbers = new ArrayList<>();
        for(int i=0;i<user.getUserGameCnt();i++){
            randomNumbers.add(RandomUtil.makeRandomNumbers());
        }
        user.setRandomNumber(randomNumbers);
        OutputView.printRandomNumbers(randomNumbers);
    }
}
