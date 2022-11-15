package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.LottoShop;
import lotto.domain.WinningLotto;
import lotto.dto.RoundResult;
import lotto.util.Validation;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {
    public static void main(String[] args) {
       try {
           String money = InputView.receivePurchaseMoney();
           LottoTicket lotteryTicket = LottoShop.buyLottos(Validation.validateStringNumber(money));
           ResultView.printLottoNumbers(lotteryTicket.exportLottoNumbers());
           Lotto winningNumbers = new Lotto(InputView.getListOfInteger());

           String bonusNumber = InputView.receiveBonusNumber();
           WinningLotto winningLottery = new WinningLotto(winningNumbers, Integer.parseInt(bonusNumber));

           RoundResult roundResult = lotteryTicket.getResult(winningLottery);
           ResultView.printResult(roundResult);
       }catch(IllegalArgumentException e) {
           System.out.print("[ERROR] " + e.getMessage());
       }

    }

}
