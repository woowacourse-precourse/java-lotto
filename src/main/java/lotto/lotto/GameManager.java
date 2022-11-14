package lotto.lotto;

import lotto.ui.InputView;
import lotto.ui.OutputView;

import java.util.List;

public class GameManager {

    private Lotto winningLotto;
    private int bonusNumber;
    private LottoManager lottoManager;

    public void playLotto() {
        try {
            buyingLotto();
            inputWinningAndBonusNumber();
            calculateRank();
            OutputView.outputWinningStat(lottoManager.getRanks());
            OutputView.outputEarningRate(String.valueOf(Math.round(lottoManager.calculateEarningRate() * 10) / 10.0));
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }

    private void buyingLotto() {
        int buyingAmount = InputView.inputBuyingAmount();
        OutputView.outputBlankLine();
        lottoManager = new LottoManager(buyingAmount, new RandomNumberGenerator());
        OutputView.outputBuyingAmount(buyingAmount);
        for (Lotto lotto : lottoManager.getLottos()) {
            OutputView.outputLotto(lotto.getNumbers());
        }
        OutputView.outputBlankLine();
    }

    private void inputWinningAndBonusNumber() {
        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        this.winningLotto = new Lotto(winningNumbers);
        OutputView.outputBlankLine();
        this.bonusNumber = InputView.inputBonusNumber();
        OutputView.outputBlankLine();
        LottoValidation.validateUniqueWinningNumbersWithBonus(winningNumbers, bonusNumber);
    }

    private void calculateRank() {
        lottoManager.calculateTotalRanks(this.winningLotto, this.bonusNumber);
    }
}
