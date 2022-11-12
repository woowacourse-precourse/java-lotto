package lotto;

import java.util.List;

public class LottoController {

    public void start() {
        try {
            InputView inputView = new InputView();

            LottoAmount lottoAmount = inputAmount(inputView.getPurchaseAmount());
            List<List<Integer>> lotto = lottoAmount.buyLotto();
            Lotto winningLotto = inputLotto(inputView.getWinningNumbers());
            BonusNumber bonusNumber = inputBonusNumber(inputView.getBonusNumber());

            Statistics statistics = new Statistics(winningLotto.getWinningLotto(), bonusNumber.getBonusNumber());
            statistics.compare(lotto, lottoAmount.getPurchaseAmount());
        } catch (IllegalArgumentException errorMessage) {
            System.out.println(errorMessage);
        }
    }
    private LottoAmount inputAmount(int input) {
        return new LottoAmount(input);
    }

    private Lotto inputLotto(List<Integer> input) {
        return new Lotto(input);
    }

    private BonusNumber inputBonusNumber(int input) {
        return new BonusNumber(input);
    }
}
