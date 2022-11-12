package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class EarningInfo {
    private final Map<LottoGrade, Integer> countOfEachGrade;
    private final long totalEarning;
    private final double earningRate;

    public EarningInfo(Map<LottoGrade, Integer> countOfEachGrade, long totalEarning, double earningRate) {
        this.countOfEachGrade = countOfEachGrade;
        this.totalEarning = totalEarning;
        this.earningRate = earningRate;
    }

    public int getCountOfGrade(LottoGrade grade){
        return countOfEachGrade.getOrDefault(grade, 0);
    }

    public long getTotalEarning() {
        return totalEarning;
    }

    public double getEarningRate() {
        return earningRate;
    }
}
