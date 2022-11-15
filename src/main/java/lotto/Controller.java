package lotto;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.LottoTickets;
import lotto.model.Purchase;
import lotto.model.Result;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.output.BuyListView;
import lotto.view.output.SummaryView;

public class Controller {
    public static LottoTickets createLottoTickets() {
        int inputAmount = InputView.getPurchaseAmount();
        Purchase purchase = new Purchase(inputAmount);
        LottoTickets lottoTickets = new LottoTickets(purchase);
        BuyListView.show(lottoTickets.getTickets(), purchase.getAmount());
        return lottoTickets;
    }

    public static WinningNumbers createWinningLotto() {
        List<Integer> inputWinningNumbers = InputView.createWinningNumbers();
        return new WinningNumbers(inputWinningNumbers);
    }

    public static BonusNumber createBonusNumber(WinningNumbers winningNumbers) {
        int inputBonusNumber = InputView.createBonusNumber();
        return new BonusNumber(inputBonusNumber, winningNumbers);
    }

    public static void printSummary(LottoTickets lottoTickets, WinningNumbers winningNumbers,
                                     BonusNumber bonusNumber) {
        Result result = new Result(lottoTickets, winningNumbers, bonusNumber);
        SummaryView.showResult(result);
        SummaryView.showEarning(result, lottoTickets.getTickets().size());
    }
}
