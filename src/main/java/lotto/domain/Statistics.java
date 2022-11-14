package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Statistics {
    private int[] gradeCount;
    private int earningRate;

    public Statistics(List<Integer> winningNumbers, List<Lotto> lottos){
        countGrade(winningNumbers, lottos);
        calculateEarningRate();
    }

    private void countGrade(List<Integer> winningNumbers, List<Lotto> lottos){
        for(Lotto lotto : lottos){
            int grade = compare(winningNumbers, lotto);
            gradeCount[grade]++;
        }
    }

    private int compare(List<Integer> winningNumbers, Lotto lotto){
        return 0;
    }

    private void calculateEarningRate(){

    }

    private int calculateEarning(){
        return 0;
    }

    public int[] getGradeCount() {
        return gradeCount;
    }

    public int getEarningRate() {
        return earningRate;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "winningCount=" + Arrays.toString(gradeCount) +
                ", earningRate=" + earningRate +
                '}';
    }
}
