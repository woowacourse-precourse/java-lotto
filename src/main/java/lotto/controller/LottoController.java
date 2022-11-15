package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoGenerator;
import lotto.domain.Rank;
import lotto.domain.User;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {

    private int moneyAmount;
    private int bonusNumber;
    private List<Lotto> lottos = new ArrayList<>();

    private Lotto winningLotto;
    private User user = new User();
    private LottoGenerator lottoGenerator = new LottoGenerator();
    private LottoCalculator lottoCalculator = new LottoCalculator();

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

    public void generateWinningLotto() {
        InputView.requestWinningLottoNumber();
        List<Integer> winningNumber = user.inputOfWinningNumber();
        winningLotto = new Lotto(winningNumber);

        InputView.requestBonusNumber();
        bonusNumber = user.inputOfBonusNumber(winningLotto);
    }

    public void calculateLottoResult() {
        Map<Rank, Integer> lottoResult = lottoCalculator.calculateResult(lottos, winningLotto, bonusNumber);
        double profitRate = lottoCalculator.calculateProfitRate(moneyAmount);
        OutputView.printLottoResult(lottoResult, profitRate);
    }
}
