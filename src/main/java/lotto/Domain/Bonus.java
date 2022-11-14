package lotto.Domain;


import lotto.Domain.Exception.CheckException;

import java.util.HashSet;
import java.util.List;

public class Bonus {
    private final int number;

    public Bonus(String bonus, List<Integer> sixNum) throws IllegalArgumentException{
        this.number = convertAndValidate(bonus, sixNum);
    }

    private int convertAndValidate(String bonus, List<Integer> sixNum) throws IllegalArgumentException{
        CheckException checkException = new CheckException();

        int number = checkException.check_HaveChar_And_Convert(bonus);

        sixNum.add(number);
        HashSet<Integer> compareNum = new HashSet<>(sixNum);
        checkException.check_RelativeLottoSize(sixNum.size(), compareNum.size());

        checkException.check_OutOfRange(number);
        return number;
    }


    public int getNumber() {
        return number;
    }
}
