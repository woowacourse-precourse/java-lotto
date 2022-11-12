package view;

import camp.nextstep.edu.missionutils.Console;
import constant.ErrorMessage;
import java.util.List;
import util.ValidateBonusNumber;

public class InputBonusNumber {


    static int bonusNumber;

    public static void inputBonusNumber() {
        OutputView.printInputBonus();
        String inputBonusNumber = Console.readLine();
        ValidateBonusNumber.validateBonusNumber(inputBonusNumber);
    }

    public static int getBonusNumber() {
        return bonusNumber;
    }

}
