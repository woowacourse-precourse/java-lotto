package lotto.domain;

import java.util.List;

public class NumberMatcher {
    public int winningNumberCount(List<Integer> buyer, List<Integer> winningNumber) {
        int count = 0;
        for (Integer number: buyer) {
            if(winningNumber.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
