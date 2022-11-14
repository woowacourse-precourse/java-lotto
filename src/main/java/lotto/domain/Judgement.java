package lotto.domain;

import java.util.List;

public class Judgement {
    public int result = 0;
    public int rankLotto(List<Integer> lottery, List<Integer> winningNumber) {
        for (int i=0; i<lottery.size(); i++){
            int correctNumber = winningNumber.get(i);
            if (lottery.contains(correctNumber)) {
                result ++;
            }
        }
        return result;
    }
}
