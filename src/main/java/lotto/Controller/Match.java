package lotto.Controller;


import java.util.HashSet;
import java.util.List;

public class Match {

    private final int lottoResults;
    public final List<Integer> winningNumbers;
    public final List<Integer> lotto;
    public final int bonusNumber;

    public Match(List<Integer> winningNumers, List<Integer> lotto, int bounusNumber) {
        this.winningNumbers= winningNumers;
        this.lotto = lotto;
        this.bonusNumber=bounusNumber;
        this.lottoResults = getLottoResults();
    }

    public int getResults() {
        return lottoResults;
    }

    private int getOverlapCount() {
        HashSet<Integer> winningNumberSet = new HashSet<>(this.winningNumbers);
        HashSet<Integer> lottoSet = new HashSet<>(this.lotto);
        HashSet<Integer> intersection = new HashSet<>(winningNumberSet);

        intersection.retainAll(lottoSet);

        return intersection.size();
    }

    private boolean isContainBonusNumber() {
        return lotto.contains(this.bonusNumber);
    }

    private int getLottoResults() {
        int overlapCount = getOverlapCount();
        if (overlapCount == 6) {
            return 2000000000;
        }
        if (overlapCount == 5) {
            return bonusCalculate();
        }
        if (overlapCount == 4) {
            return 50000;
        }
        if (overlapCount == 3) {
            return 5000;
        }
        return 0;
    }

    private int bonusCalculate() {
        if (isContainBonusNumber()) {
            return 30000000;
        }
        return 1500000;
    }


}
