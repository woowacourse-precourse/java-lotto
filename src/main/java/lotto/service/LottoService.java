package lotto.service;

import lotto.domain.LottoMachine;
import lotto.domain.User;

public class LottoService {

    private User user = new User();
    private LottoMachine lottoMachine;

    public void buyLotto(int money) {
        user = User.initUserLotto(money);
    }

    public void saveWinningLotto(String bonusNumber) {
        lottoMachine = LottoMachine.initLottoMachineNumber(bonusNumber).get();
    }

}
