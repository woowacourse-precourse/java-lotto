package lotto;

import lotto.domain.LottoCard;
import lotto.domain.Money;
import lotto.domain.WinningLottoNumber;
import lotto.view.InputView;

public class Application {

    public static void main(String[] args) {
        Money money = new Money(InputView.inputMoney());
        LottoCard lottoCard = new LottoCard(money.getMoney());
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(InputView.inputWinLottoNumber());


    }
}
