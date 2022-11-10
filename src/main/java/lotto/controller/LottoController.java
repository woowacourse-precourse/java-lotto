package lotto.controller;

import lotto.Utils.InputValid;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private User user;
    private Lotto lotto;

    public LottoController() {
        user=new User();
    }

    public void startLotto(){
        inIt();

        OutputView.printGameCount(user.getUserGameCnt());

        lotto=new Lotto(InputView.getLottoNumber());
    }

    private void inIt(){
        user.setUserPrice(InputView.getUserPriceNumber());

    }
}
