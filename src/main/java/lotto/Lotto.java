package lotto;

import lotto.Utils.CommonUtil;
import lotto.domain.WinInfo;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    private WinInfo winInfo;

    public Lotto(List<Integer> numbers) {
        CommonUtil.validateLotto(numbers);
        try {
            Collections.sort(numbers);
        } catch (UnsupportedOperationException e) {
        }
        this.numbers = numbers;
    }

    public void drawLotto(List<Integer> winNumbers, int bonus) {
        int matchCount = 0;

        for (Integer number : numbers) {
            if (winNumbers.contains(number)) {
                matchCount++;
            }
        }

        winInfo = WinInfo.convert(matchCount, numbers.contains(bonus));
    }

    public WinInfo getWinInfo() {
        return winInfo;
    }

    public void print() {
        System.out.println(numbers);
    }
}
