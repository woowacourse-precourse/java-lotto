package lotto.Output.Statistic;

import java.util.List;

public class StatisticOutput {
    public void getStatisticOutput(List<Integer> prizeRanks) {
        for(PrintWinning winMessage: PrintWinning.values()){
            for(Integer prizeRank : prizeRanks){
                System.out.printf(winMessage.message(),Integer.valueOf(prizeRank));
            }
        }
    }
}
