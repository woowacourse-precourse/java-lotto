package lotto;

import java.util.List;

public class LottoController {

    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        try {
            start();
        } catch (IllegalArgumentException errorMessage) {
            System.out.println(errorMessage);
        }
    }

    private void start() {

        LottoAmount lottoAmount = inputAmount();
        List<List<Integer>> lotto = lottoAmount.buyLotto();
        Lotto winningLotto = inputLotto();
        BonusNumber bonusNumber = inputBonusNumber();

        Statistics statistics = new Statistics(winningLotto.getWinningLotto(), bonusNumber.getBonusNumber());
        statistics.compare(lotto, lottoAmount.getPurchaseAmount());
    }

    private LottoAmount inputAmount() {
        int number = inputView.getPurchaseAmount();
        return new LottoAmount(number);
    }

    private Lotto inputLotto() {
        List<Integer> numbers = inputView.getWinningNumbers();
        return new Lotto(numbers);
    }

    private BonusNumber inputBonusNumber() {
        int number = inputView.getBonusNumber();
        return new BonusNumber(number);
    }
}
