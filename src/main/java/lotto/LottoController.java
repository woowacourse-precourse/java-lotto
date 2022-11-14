package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoService;
import lotto.domain.UserLotto;
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

    public void start() {
        List<LottoRank> lottoResult = service.createLottoResult(lotto.getNumbers(), userLotto.getUserLotto());
        //수익률 문제 고치자
    }
}
