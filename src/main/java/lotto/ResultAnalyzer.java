package lotto;

import java.util.List;

public class ResultAnalyzer {

    private List<Integer> winNumbers;
    private int bonusNumber;

    public ResultAnalyzer(List<Integer> winNumbers, int bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public double calculateRateOfReturn(List<Lotto> wholeLotto, int[] rankRecord) {
        double expense = wholeLotto.size() * 1000;
        int income = 0;
        for (int i = 1; i < 6; i++) {
            income += Prize.valueOfRank(i).getCashPrize() * rankRecord[i];
        }

        return (double) Math.round((income / expense * 100) * 10) / 10;
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
