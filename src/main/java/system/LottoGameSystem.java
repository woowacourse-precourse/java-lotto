package system;

import system.process.Buying;
import system.process.StatisticsCalculator;
import system.process.WinningLottoRegister;
import utils.Input;

public class LottoGameSystem {

    private Buying boughtLottos;
    private WinningLottoRegister winningLotto;
    private StatisticsCalculator statisticsCalculator;

    public void runGame() {
        if (!prepareLotto()) {
            return;
        }
        calculateStatistics();
    }

    private boolean prepareLotto() {
        try {
            boughtLottos = new Buying();
            winningLotto = new WinningLottoRegister();
            return true;
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
            return false;
        }
    }

    private void calculateStatistics() {
        statisticsCalculator = new StatisticsCalculator(boughtLottos, winningLotto);
    }


}
