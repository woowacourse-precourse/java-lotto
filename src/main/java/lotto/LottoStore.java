package lotto;

import java.util.List;

public class LottoStore {

    public void enter() {
        int money = InputConsole.purchaseMoney();
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.buy(money);
        OutputConsole.printLottoList(lottos);
        List<Integer> winningNumber = InputConsole.winningNumber();
        int bonusNumber = InputConsole.bonusNumber();
        OutputConsole.printWinningList(lottos, winningNumber, bonusNumber);
        OutputConsole.printProfitRate(lottos, money, winningNumber, bonusNumber);
    }
}
