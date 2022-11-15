package lotto;

import java.util.List;

public class CalculatingLotto {
    private static final int LOTTONUMCOUNT=6;
    private static final int YES=1;
    private static final int NO=0;
    private enum Rank {FAILED, FIRST, SECOND, THIRD, FOURTH, FIFTH}

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

    public boolean checkBonus(int bonus, List<Integer> oneLotto){
        for(int index=0;index<LOTTONUMCOUNT;index++){
            if(bonus==oneLotto.get(index)){
                return true;
            }
        }
        return false;
    }

    public int getLottoRank(int sameNumCount, boolean bonusCount){
        if(sameNumCount==3){
            return Rank.FIFTH.ordinal();
        }
        if(sameNumCount==4){
            return Rank.FOURTH.ordinal();
        }
        if(sameNumCount==5){
            if(!bonusCount){
                return Rank.THIRD.ordinal();
            }
            return Rank.SECOND.ordinal();
        }
        if(sameNumCount==6){
            return Rank.FIRST.ordinal();
        }
        return Rank.FAILED.ordinal();
    }

    public List<Integer> calculateAllLotto(List<Integer> winningLotto, int bonus, List<List<Integer>> allLotto){
        return null;
    }

}
