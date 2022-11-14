package lotto;


import java.util.HashSet;
import java.util.List;

public class Match {

    private final int lottoResults;

    public Match(List<Integer> winningNumers, List<Integer> lottoes, int bounusNumber) {
        this.lottoResults = getLottoResults(winningNumers, lottoes, bounusNumber);
    }

    public int getResults() {
        return lottoResults;
    }

    private int getOverlapedCount(List<Integer> winningNumer, List<Integer> lotto) {
        HashSet<Integer> winningNumberSet = new HashSet<>(winningNumer);
        HashSet<Integer> lottoSet = new HashSet<>(lotto);
        HashSet<Integer> intersection = new HashSet<>(winningNumberSet);

        intersection.retainAll(lottoSet);

        return intersection.size();
    }

    private boolean isContainBonusNumber(List<Integer> lotto, int bonusNumber){
        return lotto.contains(bonusNumber);
    }

    private int getLottoResults(List<Integer> winningNumers, List<Integer> lotto, int bonusNumber){
        int overlapedCount = getOverlapedCount(winningNumers, lotto);
        if(overlapedCount ==6){
            return 2000000000;
        }
        if(overlapedCount== 5){
            return bonusCalculate(lotto, bonusNumber);
        }
        if(overlapedCount==4){
            return 50000;
        }
        if(overlapedCount==3){
            return 5000;
        }
        return 0;
    }
    private int bonusCalculate(List<Integer> lotto, int bonusNumber){
        if(isContainBonusNumber(lotto, bonusNumber)){
            return 30000000;
        }
        return 1500000;
    }


}
