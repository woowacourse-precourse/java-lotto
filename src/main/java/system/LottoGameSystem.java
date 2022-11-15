package system;

import system.process.Buying;
import system.process.StatisticsCalculator;
import system.process.WinningLottoRegister;
import view.StatisticsView;

public class LottoGameSystem {
    private Buying buying;
    private WinningLottoRegister winningLottoRegister;
    private StatisticsCalculator statisticsCalculator;

    public void runGame() {
        boolean preparing = prepareLotto();

        if (preparing == false) {
            return;
        }
        runStatisticsCalculator();
    }

    private boolean prepareLotto() {
        try {
            buying = new Buying();
            winningLottoRegister = new WinningLottoRegister();
            return true;
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
            return false;
        }
    }

    private void runStatisticsCalculator() {
        statisticsCalculator = new StatisticsCalculator(buying, winningLottoRegister);
        StatisticsView.printStatistics(statisticsCalculator.getStatistics());
    }
}
