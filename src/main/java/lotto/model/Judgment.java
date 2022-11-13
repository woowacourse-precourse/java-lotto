package lotto.model;

import java.util.*;

public class Judgment {


    public Map<Integer, Boolean> putCorrectLottoInfo(List<Lotto> lottos,List<Integer> winnerNumber,int bonusNum){
        Map<Integer, Boolean> correctLottoInfo = new HashMap<>();
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumber = lotto.getNumbers();
            correctLottoInfo.put(correctCountLottoNumberAndWinnerNum(lottoNumber, winnerNumber)
                    ,isBonusNumberInLottoNumber(winnerNumber,bonusNum)) ;
        }
        return correctLottoInfo;
    }


    public int correctCountLottoNumberAndWinnerNum(List<Integer> lottoNumber, List<Integer> winnerNumber) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (winnerNumber.contains(lottoNumber.get(i))) {
                count++;
            }
        }
        return count;
    }

    public boolean isBonusNumberInLottoNumber(List<Integer> winningNumber, int bonusNum) {
        return winningNumber.contains(bonusNum);
    }

}
