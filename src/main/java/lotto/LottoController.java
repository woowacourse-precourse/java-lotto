package lotto;

import lotto.domain.*;
import lotto.ui.LottoInput;
import lotto.ui.LottoOutput;

import java.util.List;

public class LottoController {
    private LottoInput input = new LottoInput();
    private LottoOutput output = new LottoOutput();
    private LottoService service = new LottoService();
    private Lotto lotto;
    private UserLotto userLotto;


    public void initLotto() {
        List<Integer> winningNumber = input.readWinningNumber();
        lotto = new Lotto(winningNumber);
    }

    public void initUserLotto() {
        int money = input.readMoney();
        int lottoAmount = service.getLottoAmount(money);

        userLotto = new UserLotto(lottoAmount);

        output.printUserLotto(userLotto.getUserLotto());
    }

    public void initBonusNumber() {
        int bonusNumber = input.readBonusNumber();
        BonusNumber.BONUS_NUMBER.setNumber(bonusNumber);
    }
}
