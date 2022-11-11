package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    public Map<Integer, Boolean> countWinning(List<Integer> lotto, List<List<Integer>> userLotto) {
        Map<Integer, Boolean> result = new HashMap<>();

        for(List<Integer> numbers : userLotto) {
            int count = countCorrect(lotto, numbers);
            boolean bonusNumber = countBonus(numbers);

            if(count >= 3) {
                result.put(count, bonusNumber);
            }
        }

        return result;
    }

    public int countCorrect(List<Integer> lotto, List<Integer> userLotto) {
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
    public boolean countBonus(List<Integer> userLotto) {
        if(userLotto.contains(BonusNumber.BONUS_NUMBER.getNumber())) {
            return true;
        }
        return false;
    }
}
