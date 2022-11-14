package lotto.Output.Statistic;

import java.util.List;

public class StatisticOutput {
    public void getStatisticOutput(List<Integer> prizeRanks) {
        int prizeRankIndex = 0;
        for(PrintWinning winMessage: PrintWinning.values()){
            System.out.printf(winMessage.message(), prizeRanks.get(prizeRankIndex));
            prizeRankIndex++;
        }
    }
}
