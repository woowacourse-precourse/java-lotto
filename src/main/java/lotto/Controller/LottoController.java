package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.ValidNumbers;
import lotto.Service.LottoService;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private static final int MIN_COST = ValidNumbers.MIN_COST.getValue();
    private static LottoService lottoService = new LottoService();
    private static List<Lotto> totalLotto = new ArrayList<>();

    public void start() {
        input();
        output();
    }

    public void input() {
        InputView inputView = new InputView();

        int money = inputView.readInput();

        Lotto lotto;
        int quantity = (money / MIN_COST);
        while (quantity-- > 0) {
            lotto = lottoService.createRandomLotto();
            totalLotto.add(lotto);
        }
    }

    public void output() {
        OutputView outputView = new OutputView();

        outputView.printTotal(totalLotto);
    }

}
