package view;

import camp.nextstep.edu.missionutils.Console;
import util.ValidateBonusNumber;

public class InputBonusNumber {


    static int bonusNumber;

    public static void inputBonusNumber() {
        OutputView.printInputBonus();
        String inputBonusNumber = Console.readLine();
        bonusNumber = ValidateBonusNumber.validateBonusNumber(inputBonusNumber);
    }

    public static int getBonusNumber() {
        return bonusNumber;
    }

}
