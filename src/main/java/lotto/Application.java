package lotto;

import java.util.List;
import lotto.domain.LottoCard;
import lotto.domain.Money;
import lotto.domain.WinningLottoNumber;
import lotto.domain.WinningStatistics;
import lotto.view.InputView;

public class Application {

    public static void main(String[] args) {
        Money money = new Money(InputView.inputMoney());
        LottoCard lottoCard = new LottoCard(money.getMoney());
        WinningLottoNumber winningLotto = new WinningLottoNumber(InputView.inputWinLottoNumber());
        int bonusNum = winningLotto.setBonusNumber(InputView.inputBonusLottoNumber());

        WinningStatistics winningStatistics = new WinningStatistics(lottoCard, winningLotto,
            bonusNum);

    }
}
