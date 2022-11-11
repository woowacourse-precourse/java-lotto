package lotto.model;

import lotto.enums.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Draw {
    private Lotto winningLotto;
    private int bonusNum;

    private Map<Integer,Rank> rankClassification;

    public Draw(Lotto winningLotto, int bonusNum){
        validateBonusNumRange(bonusNum);
        setRankClassification();
        this.winningLotto = winningLotto;
        this.bonusNum = bonusNum;
    }

    public Map<Rank,Integer> getWinningStats(List<Lotto> lottoPaper) {
        return null;
    }

    private void setRankClassification(){
        Map<Integer,Rank> rankClassification = new HashMap<>();
        rankClassification.put(6,Rank.first);
        rankClassification.put(5,Rank.third);
        rankClassification.put(4,Rank.fourth);
        rankClassification.put(3,Rank.fifth);
        this.rankClassification = rankClassification;
    }

    private Rank tryLottoRank(Lotto tryLotto) {
        int winningCount = winningNumSize(tryLotto);
        boolean bonusExist = isBonusExist(this.bonusNum);

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
