package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.User;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private int moneyAmount;
    private List<Lotto> lottos = new ArrayList<>();

    private User user = new User();
    private LottoGenerator lottoGenerator = new LottoGenerator();

    public void buyLotto() {
        InputView.requestAmount();
        moneyAmount = user.inputOfMoneyAmount();
        int lottoAmount = moneyAmount / 1000;
        OutputView.printAmount(lottoAmount);
    }

    public void generateLottos(int lottoAmount) {
        for (int i = 0; i < lottoAmount; i++) {
            Lotto lotto = lottoGenerator.makeLotto();
            lottos.add(lotto);
        }
        OutputView.printLottos(lottos);
    }
}
