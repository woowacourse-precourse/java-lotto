package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private Map<Grade, Integer> gradeCount = new HashMap<>();
    private int earningRate;

    public Statistics(WinningNumbers winningNumbers, LottoGenerator lottoGenerator){
        countGrade(winningNumbers, lottoGenerator.getLottos());
        calculateEarningRate(lottoGenerator.getNumberOfLotto());
    }

    private void countGrade(WinningNumbers winningNumbers, List<Lotto> lottos){
        for(Grade grade : Grade.values()){
            gradeCount.put(grade, 0);
        }

        for(Lotto lotto : lottos){
            int count = (int)lotto.getNumbers().stream().filter(v -> winningNumbers.getNumbers().contains(v)).count();
            Grade grade = getGrade(winningNumbers, lotto, count);
            gradeCount.put(grade, gradeCount.get(grade)+1);
        }
    }

    private Grade getGrade(WinningNumbers winningNumbers, Lotto lotto, int count){
        if(count == Grade.FIRST.getMatchCount()) {
            return Grade.FIRST;
        }
        if(count == Grade.SECOND.getMatchCount() && lotto.getNumbers().contains(winningNumbers.getBonus())){
            return Grade.SECOND;
        }
        if(count == Grade.THIRD.getMatchCount() && !lotto.getNumbers().contains(winningNumbers.getBonus())){
            return Grade.THIRD;
        }
        if(count == Grade.FOURTH.getMatchCount()){
            return Grade.FOURTH;
        }
        if(count == Grade.FIFTH.getMatchCount()){
            return  Grade.FIFTH;
        }
        return Grade.NOTHING;
    }

    private void calculateEarningRate(int numberOfLotto){
        int earning = calculateEarning();
        int purchaseAmount = numberOfLotto * LottoGenerator.LOTTO_PRICE;

        earningRate = earning / purchaseAmount * 100;
    }

    private int calculateEarning(){
        return 0;
    }

    public Map<Grade, Integer> getGradeCount() {
        return gradeCount;
    }

    public int getEarningRate() {
        return earningRate;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "winningCount=" + gradeCount +
                ", earningRate=" + earningRate +
                '}';
    }
}
