package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMaker;
import lotto.domain.Result;
import lotto.domain.ResultMaker;
import lotto.io.ConsoleInput;
import lotto.io.ConsoleOutput;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        ConsoleOutput.printGuide(ConsoleOutput.PURCHASE_AMOUNT);
        int purchaseAmount = ConsoleInput.getPurchaseAmount();
        List<Lotto> lottos = LottoMaker.makeLotto(purchaseAmount);

        ConsoleOutput.printNumOfLotto(purchaseAmount/LottoMaker.ONE_LOTTO_PRICE);
        ConsoleOutput.printLottos(lottos);

        ConsoleOutput.printGuide(ConsoleOutput.WINNING_NUMBER);
        List<Integer> winningNumbers = ConsoleInput.getWinningNumbers();
        ConsoleOutput.printGuide(ConsoleOutput.BONUS_NUMBER);
        int bonusNumber = ConsoleInput.getBonusNumber();
        ResultMaker resultMaker = new ResultMaker(winningNumbers, bonusNumber);

        List<Result> results = new ArrayList<>();
        for (Lotto lotto : lottos) {
            results.add(resultMaker.getTheResult(lotto.getNumbers()));
        }
        ConsoleOutput.printWinningStatistics(results, purchaseAmount);
    }
}
