package lotto.service;

import java.util.Arrays;
import java.util.List;

public class WinningMoney {
    private final static int NONE = 0;
    private final static int FIRST = 2000000000;
    private final static int SECOND = 30000000;
    private final static int THIRD = 1500000;
    private final static int FOURTH = 50000;
    private final static int FIFTH = 5000;
    private final static List<Integer> MONEYS =
            Arrays.asList(NONE, NONE, NONE, FIFTH, FOURTH, THIRD, SECOND, FIRST);
    private int myGrade;

    CheckNumbers checkNumbers = new CheckNumbers();


    public int getMyMoney(List<Integer> winningNumbers, List<Integer> myNumbers, int bonusNumber) {
        myGrade = checkNumbers.getCorrect(winningNumbers, myNumbers, bonusNumber);
        return MONEYS.get(myGrade);
    }
}
