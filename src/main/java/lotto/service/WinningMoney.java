package lotto.service;

import lotto.domain.MyLottoNumbers;
import lotto.domain.WinningLottoNumbers;

import java.util.ArrayList;
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

    MyLottoNumbers myLottoNumbers = new MyLottoNumbers();
    WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers();
    CheckNumbers checkNumbers = new CheckNumbers();

    List<Integer> winningNumbers = winningLottoNumbers.getWinningNumbers();
    int bonusNumber = winningLottoNumbers.getBonusNumber();
    List<Integer> myNumbers = myLottoNumbers.getMyNumbers();
    int myGrade;

    public int getMyGrade() {
        myGrade = checkNumbers.getCorrect(winningNumbers, myNumbers, bonusNumber);
        return MONEYS.get(myGrade);
    }
}
