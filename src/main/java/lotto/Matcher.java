package lotto;

import java.util.List;

public class Matcher {
    public int getCountOfCommonElement(Lotto lotto, List<Integer> winNumbers) {
        List<Integer> myNumbers = lotto.getNumbers();
        int count = 0;
        for (Integer winNumber : winNumbers) {
            if (myNumbers.contains(winNumber)){
                count++;
            }
        }

        return count;
    }

    public boolean doesContainBonusNumber(Lotto lotto, int bonusNumber) {
        List<Integer> myNumbers = lotto.getNumbers();
        return myNumbers.contains(bonusNumber);
    }
}
