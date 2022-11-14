package lotto;

import java.util.List;

public class StatisticsAnalyzer {

    private List<Integer> winNumbers;
    private int bonusNumber;

    public StatisticsAnalyzer(List<Integer> winNumbers, int bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public double calculateRateOfReturn(List<Lotto> wholeLotto) {
        return 0;
    }

}
