package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningCalculate {

    private final List<Integer> RANK;
    public WinningCalculate(List<Integer> winningNumber, List<Lotto> lottoNumber, int bonusNumber){
        this.RANK = winningCalculate(winningNumber,lottoNumber,bonusNumber);
    }
    private List<Integer> winningCalculate(List<Integer> winningNumber, List<Lotto> lottoNumber, int bonusNumber) {
        List<Integer> rank = new ArrayList<>();


        for (Lotto lotto : lottoNumber) {
            int sameCount;
            
            sameCount = findCollectNumber(lotto, winningNumber);
            if (collectNumberSize(lotto, bonusNumber, sameCount) < 6)
                rank.add(collectNumberSize(lotto, bonusNumber, sameCount));
        }

        return rank;
    }

    private int findCollectNumber(Lotto lotto, List<Integer> winningNumber){
        int same =0;
        for (Integer i : lotto.getNumbers()){
            if(winningNumber.contains(i)){
                same++;
            }
        }
        return same;
    }

    private int collectNumberSize(Lotto lotto, int bonusNumber, int sameCount){
        int rank=6;
        List<Integer> bonusCompare = lotto.getNumbers();
        if(sameCount == 6) rank=1;
        if(sameCount == 5 &&  bonusCompare.contains(bonusNumber)) rank=2;
        if(sameCount == 5 && !bonusCompare.contains(bonusNumber)) rank=3;
        if(sameCount == 4) rank=4;
        if(sameCount == 3) rank=5;

        return rank;
    }

    public List<Integer> getRANK() {
        return RANK;
    }
}
