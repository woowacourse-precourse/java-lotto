package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.User;
import lotto.view.InputView;

public class LottoController {

    User user = new User();
    private LottoMachine lottoMachine;

    public void buyLotto() {
        int money = Integer.parseInt(InputView.inputMoney());
        user = User.initUserLotto(money);
    }

    public void initWinningLotto() {
        String bonusNumber = InputView.inputWinningNumber();
        lottoMachine = LottoMachine.initLottoMachineNumber(bonusNumber).get();
    }
}
