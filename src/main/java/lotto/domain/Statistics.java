package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Statistics {
    private int[] winningCount;
    private int earningRate;

    public Statistics(List<Integer> winningNumbers, List<Lotto> lottos){
        compare(winningNumbers, lottos);
        calculateEarningRate();
    }

    private void compare(List<Integer> winningNumbers, List<Lotto> lottos){

    }

    private void calculateEarningRate(){

    }

    private int calculateEarning(){
        return 0;
    }

    public int[] getWinningCount() {
        return winningCount;
    }

    public int getEarningRate() {
        return earningRate;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "winningCount=" + Arrays.toString(winningCount) +
                ", earningRate=" + earningRate +
                '}';
    }
}
