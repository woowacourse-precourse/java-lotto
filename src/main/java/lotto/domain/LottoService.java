package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    public Map<Integer, Boolean> countWinning(List<Integer> lotto, List<List<Integer>> userLotto) {
        Map<Integer, Boolean> lottoResult = new HashMap<>();

        for(List<Integer> numbers : userLotto) {
            int count = countMatchNumber(lotto, numbers);
            boolean bonusNumber = checkBonusNumber(count, numbers);

            if(count >= 3) {
                lottoResult.put(count, bonusNumber);
            }
        }

        return lottoResult;
    }

    public int countMatchNumber(List<Integer> lotto, List<Integer> userLotto) {
        int count = 0;

        for(int number : userLotto) {
            if(lotto.contains(number)) {
                count++;
            }
        }
        return count;
    }


    /**
     * 입력받는 lotto가 bonus 번호를 가지고있으면 true, 아니면 false 반환
     * @param userLotto
     * @return
     */
    public boolean checkBonusNumber(int matchNumber, List<Integer> userLotto) {
        if(matchNumber == LottoRank.SECOND.getMatchNumber()) {
            if(userLotto.contains(BonusNumber.BONUS_NUMBER.getNumber())) {
                return true;
            }
        }
        return false;
    }
}
