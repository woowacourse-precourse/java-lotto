package lotto.domain;

import java.util.List;

public class Compare {
    public int matchCount(List<Integer> lotto, List<Integer> winning) { // 당첨 번호
        int result = 0;
        for (int i = 0; i < lotto.size(); i++) {
            int winningNumber = winning.get(i);
            if (lotto.contains(winningNumber)) {
                result += 1;
            }
        }
        return result;
    }

    public boolean matchBonus(List<Integer> lotto, List<Integer> winning) { // 보너스 번호
        return lotto.contains(winning.get(6));
    }
}