package lotto;

import java.util.List;

public class Matcher {
    public int getCountOfCommonElement(Lotto lotto, List<Integer> winNumbers) {
        List<Integer> numbers = lotto.getNumbers();
        int count = 0;
        for (Integer number : numbers) {
            if (winNumbers.contains(number)){
                count++;
            }
        }

        return count;
    }

    public boolean doesContainBonusNumber(Lotto lotto, int bonusNumber) {
        return false;
    }
}
