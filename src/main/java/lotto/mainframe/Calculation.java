package lotto.mainframe;

import java.util.List;

public class Calculation {

    private final int ZERO_COUNT = 0;
    private int threeMatchCount;
    private int fourMatchCount;
    private int fiveMatchCount;
    private int fivePlusBonusMatchCount;
    private int sixMatchCount;

    public void setCCountZero() {
        threeMatchCount = ZERO_COUNT;
        fourMatchCount = ZERO_COUNT;
        fiveMatchCount = ZERO_COUNT;
        fivePlusBonusMatchCount = ZERO_COUNT;
        sixMatchCount = ZERO_COUNT;
    }

    public void calculateResult(List<List<Integer>> lotteries, int bonusNumber,
            List<Integer> answer) {
        setCCountZero();
        for (List<Integer> lotto : lotteries) {
            int count = (int) lotto.stream()
                    .filter(number -> answer.contains(number))
                    .count();
            boolean haveBonusNumber = lotto.contains(bonusNumber);
            setCount(count, haveBonusNumber);
            if (count == 6) {
                sixMatchCount++;
            }
        }
    }

    public void setCount(int count, boolean haveBonusNumber) {
        if (count == 3) {
            threeMatchCount++;
        }
        if (count == 4) {
            fourMatchCount++;
        }
        if (count == 5) {
            if (haveBonusNumber) {
                fivePlusBonusMatchCount++;
            }
            fiveMatchCount++;
        }
    }
}
