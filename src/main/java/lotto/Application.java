package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.LottoShop;
import lotto.domain.WinningLotto;
import lotto.dto.RoundResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {
    public static void main(String[] args) {
        int money = InputView.receivePurchaseMoney();
        LottoTicket lotteryTicket = LottoShop.buyLottos(money);
        ResultView.printLottoNumbers(lotteryTicket.exportLottoNumbers());

        Lotto winningNumbers = new Lotto(InputView.getListOfInteger());
        int bonusNumber = InputView.receiveBonusNumber();
        WinningLotto winningLottery = new WinningLotto(winningNumbers, bonusNumber);

        RoundResult roundResult = lotteryTicket.getResult(winningLottery);
        ResultView.printResult(roundResult);
    }
}
