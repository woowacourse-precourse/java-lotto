package lotto.Number;

import lotto.Machine.PrintMachine;
import camp.nextstep.edu.missionutils.Console;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(){
        this.bonusNumber = inputBonusNumber();
    }


    public int getBonusNumber() {
        return bonusNumber;
    }



    public int inputBonusNumber() {
        PrintMachine.BonusNumber();
        String bonus = Console.readLine();
        NumValidate.validateInteger(bonus);
        NumValidate.validateRange(bonus);
        return Integer.parseInt(bonus);
    }
}
