package lotto;

import java.util.List;

public class CalculatingLotto {
    private static final int LOTTONUMCOUNT=6;
    private static final int YES=1;
    private static final int NO=0;

    public int calculateLottoRank(List<Integer> winningLotto, int bonus, List<Integer> oneLotto){
        int sameNumCount=0;
        for(int index1=0;index1<LOTTONUMCOUNT;index1++){
            for(int index2=0;index2<LOTTONUMCOUNT;index2++){
                sameNumCount+=findSameNumber(winningLotto.get(index1),oneLotto.get(index2));
            }
        }
        boolean bonusCount=checkBonus(bonus, oneLotto);

        int rank=getLottoRank(sameNumCount,bonusCount);
        return rank;
    }

    public int findSameNumber(int winningLottoNumber, int oneLottoNumber){
        if(winningLottoNumber==oneLottoNumber){
            return YES;
        }
        return NO;
    }

    public List<Integer> calculateAllLotto(List<Integer> winningLotto, int bonus, List<List<Integer>> allLotto){
        return null;
    }

}
