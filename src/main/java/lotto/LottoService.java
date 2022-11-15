package lotto;

import java.util.List;

public class LottoService {

    public int matchNumbers(List<Integer> lotto, List<Integer> userLotto){
        int result = 0;
        for (int i=0;i<6;i++){
            if (lotto.contains(userLotto.get(i))){
                result += 1;
            }
        }
        return result;
    }

    public boolean matchBonus(List<Integer> lotto, int bonusNumber) {
        return lotto.contains(bonusNumber);
    }
}
