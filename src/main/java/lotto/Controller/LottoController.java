package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.ValidNumbers;
import lotto.Service.LottoService;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoController {

    private static final int MIN_COST = ValidNumbers.MIN_COST.getValue();
    private static LottoService lottoService = new LottoService();
    private static List<Lotto> totalLotto = new ArrayList<>();
    private static int money = 0;

    public void start() {
        input();
        result();
    }

    private void input() {
        InputView inputView = new InputView();

        money = inputView.readMoney();

        Lotto lotto;
        int quantity = (money / MIN_COST);
        while (quantity-- > 0) {
            lotto = lottoService.createRandomLotto();
            totalLotto.add(lotto);
        }
    }

    private void result() {
        OutputView outputView = new OutputView();

        outputView.printTotalLotto(totalLotto);
    }

    public List<Lotto> getTotalLottoInstance() {
        return Collections.unmodifiableList(totalLotto);
    }

    public int getMoney() {
        return money;
    }
}
