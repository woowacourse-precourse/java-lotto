package lotto.Domain.MainValue;


import lotto.Domain.Exception.CheckException;

import java.util.ArrayList;
import java.util.List;

public class Bonus {
    private final int bonusNumber;

    public Bonus(String bonus, List<Integer> sixNum) throws IllegalArgumentException{
        this.bonusNumber = convert(bonus);
        validate(sixNum);
    }

    private int convert(String bonus) throws IllegalArgumentException{
        CheckException checkException = new CheckException();
        return checkException.check_HaveChar_And_Convert(bonus);
    }

    private void validate(List<Integer> sixNum) throws IllegalArgumentException{
        CheckException checkException = new CheckException();

        List<Integer> addedSixNum = new ArrayList<>(sixNum);
        addedSixNum.add(bonusNumber);
        checkException.check_ListWithBonusNumSizeIsSeven(addedSixNum);

        checkException.check_OutOfRange(bonusNumber);
    }


    public int getNumber() {
        return bonusNumber;
    }
}
