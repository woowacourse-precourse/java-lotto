package lotto.model;

import java.util.*;

public class Judgment {

    public int correctCountLottoNumberAndWinnerNum(List<Integer> lottoNumber, List<Integer> winnerNumber){
        int count=0;
        for (int i = 0; i < 6; i++) {
            if(winnerNumber.contains(lottoNumber.get(i))){
                count++;
            }
        }
        return count;
    }

    public boolean isBonusNumberInLottoNumber(List<Integer> lottoNumber, int bonusNum){
        return lottoNumber.contains(bonusNum);
    }

}
