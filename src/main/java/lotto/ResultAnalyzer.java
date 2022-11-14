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

    public int determineRank(Lotto lotto) {
        Matcher matcher = new Matcher();
        int hit = matcher.getCountOfCommonElement(lotto, winNumbers);
        int rank = Prize.valueOfHit(hit).getRank();
        if (hit == 5 && matcher.doesContainBonusNumber(lotto, bonusNumber)) {
            rank--;
        }
        return rank;
    }
}
