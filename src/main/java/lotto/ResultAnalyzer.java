package lotto;

import java.util.List;

public class ResultAnalyzer {

    private List<Integer> winNumbers;
    private int bonusNumber;

    public ResultAnalyzer(List<Integer> winNumbers, int bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public double calculateRateOfReturn(List<Lotto> wholeLotto) {
        return 0;
    }

}
