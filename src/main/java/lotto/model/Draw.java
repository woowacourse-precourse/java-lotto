package lotto.model;

import lotto.enums.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Draw {
    private Lotto winningLotto;
    private int bonusNum;
    private Map<Rank, Integer> winningStats;
    private Map<Integer,Rank> rankClassification;

    public Draw(Lotto winningLotto, int bonusNum){
        validateBonusNumRange(bonusNum);
        setRankClassification();
        setWinningStats();
        this.winningLotto = winningLotto;
        this.bonusNum = bonusNum;
    }

    public Map<Rank,Integer> getWinningStats(List<Lotto> lottoPaper) {
        Map<Rank, Integer> winningStats = this.winningStats;
        Rank rank;

        for (Lotto tryLotto : lottoPaper) {
            rank = tryLottoRank(tryLotto);
            winningStats.compute(rank,(k,v) -> v+1);
        }
        return winningStats;
    }

    private void setRankClassification(){
        Map<Integer,Rank> rankClassification = new HashMap<>();
        rankClassification.put(6,Rank.first);
        rankClassification.put(5,Rank.third);
        rankClassification.put(4,Rank.fourth);
        rankClassification.put(3,Rank.fifth);
        rankClassification.put(2,Rank.none);
        rankClassification.put(1,Rank.none);
        rankClassification.put(0,Rank.none);
        this.rankClassification = rankClassification;
    }

    private void setWinningStats(){
        Map<Rank,Integer> winningStats = new HashMap<>();
        winningStats.put(Rank.first,0);
        winningStats.put(Rank.second,0);
        winningStats.put(Rank.third,0);
        winningStats.put(Rank.fourth,0);
        winningStats.put(Rank.fifth,0);
        this.winningStats = winningStats;
    }

    private Rank tryLottoRank(Lotto tryLotto) {
        int winningCount = winningNumSize(tryLotto);
        boolean bonusExist = isBonusExist(this.bonusNum);
        Rank rank = this.rankClassification.get(winningCount);

        if (rank.equals(Rank.third)) {
            if (bonusExist == true) {
                return Rank.second;
            }
        }
        return rank;
    }

    private int winningNumSize(Lotto tryLotto) {
        int winningCount = 0;
        Lotto winningLotto = this.winningLotto;
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        List<Integer> tryLottoNumbers = tryLotto.getNumbers();

        for (Integer tryNumber : tryLottoNumbers) {
            if (winningLottoNumbers.contains(tryNumber)) {
                winningCount++;
            }
        }

        return winningCount;
    }

    private boolean isBonusExist(int bonusNum) {
        Lotto winningLotto = this.winningLotto;
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();

        if (winningLottoNumbers.contains(bonusNum)) {
            return true;
        }
        return false;
    }

    private void validateBonusNumRange(int bonusNum) {
        if (!(bonusNum >= 1 && bonusNum <= 45)) {
            throw new IllegalArgumentException();
        }
    }



}
