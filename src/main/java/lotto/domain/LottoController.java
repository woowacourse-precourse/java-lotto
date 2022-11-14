package lotto.domain;

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
        int bonusNumber = input.readBonusNumber(lotto.getNumbers());
        BonusNumber.BONUS_NUMBER.setNumber(bonusNumber);
    }

    public void start() {
        try {
            initUserLotto();
            initLotto();
            initBonusNumber();

            List<LottoRank> lottoResult = service.createLottoResult(lotto.getNumbers(), userLotto.getUserLotto());
            output.printLottoResult(lottoResult);

            String percent = service.calculatePercent(lottoResult);
            output.printProfitPercent(percent);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
