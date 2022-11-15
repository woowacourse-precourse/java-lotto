package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    private static final int DECIMAL_POINT_MULTIPLICATION = 100;
    private static final int DECIMAL_POINT_DIVISION = 1_000;

    public void runLotto() {
        Money money = new Money(Input.inputLottoPurchaseAmount());
        Output.printPurchasesCount(money.getMoney());
        LottoNumbers lottoNumbers = new LottoNumbers(LottoFactory.ticket(money));
        Output.printLottoPurchasesNumbers(lottoNumbers);
        WinningNumber winningNumber = new WinningNumber(Lotto.from(Input.inputWinningNumbers()),
                new BonusNumber(Input.inputBonusNumber()));
        LottoResult result = getLottoResult(lottoNumbers, winningNumber);
        printResults(money, result);
    }

    private LottoResult getLottoResult(LottoNumbers lottoNumbers, WinningNumber winningNumber) {
        List<Ranking> ranks = new ArrayList<>();
        for (Lotto lotto : lottoNumbers.getLottos()) {
            Ranking rank = winningNumber.calculateRanking(lotto);
            ranks.add(rank);
        }
        return new LottoResult(ranks);
    }

    private void printResults(Money money, LottoResult lottoResult) {
        Output.printWinningTicket();
        Output.printLottoResult(lottoResult);
        Output.printProfit(DECIMAL_POINT_MULTIPLICATION * (lottoResult.checkWinningNumberPrizeMoney()
                / (double) (money.getMoney() * DECIMAL_POINT_DIVISION)));
    }

}