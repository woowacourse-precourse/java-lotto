package system;

import system.process.Buying;
import system.process.StatisticsCalculator;
import system.process.WinningLottoRegister;
import utils.Input;

public class LottoGameSystem {

    public void runGame(){

        String amountPaid = Input.inputAmountPaid();
        if(amountPaid.equals("NULL")) return;

        Buying boughtLottos = new Buying(amountPaid);
        WinningLottoRegister winningLotto = new WinningLottoRegister();

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(boughtLottos, winningLotto);
        statisticsCalculator.calculateStatistics();

    }

}
