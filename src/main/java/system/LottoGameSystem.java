package system;

import system.process.Buying;
import system.process.StatisticsCalculator;
import system.process.WinningLottoRegister;

public class LottoGameSystem {

    public void runGame(){

        Buying boughtLottos = new Buying();
        WinningLottoRegister winningLotto = new WinningLottoRegister();

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator(boughtLottos, winningLotto);
        statisticsCalculator.calculateStatistics();

    }

}
