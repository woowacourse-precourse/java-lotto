package system;

import system.process.LottoComparison;
import system.process.Purchase;
import system.process.Statistics;
import system.process.WinningLotto;

public class LottoGameSystem {

    public void runGame(){

        Purchase purchase = new Purchase();
        WinningLotto winningLotto = new WinningLotto();

        Statistics statistics = new Statistics(purchase,winningLotto);

    }

}
