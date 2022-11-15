package dto;

import domain.LottoGrade;
import java.util.Map;

public class ScratchResult {
    private final Map<LottoGrade, Integer> countOfEachGrade;
    private final long totalEarning;
    private final double earningRate;

    public ScratchResult(Map<LottoGrade, Integer> countOfEachGrade, long totalEarning, double earningRate) {
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
