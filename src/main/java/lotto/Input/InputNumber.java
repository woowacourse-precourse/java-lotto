package lotto.Input;

import camp.nextstep.edu.missionutils.Console;
import lotto.Domain.Exception.CheckException;

import java.util.ArrayList;
import java.util.List;

public class InputNumber {

    public String insertMoney() {
        PrintInstruction.BUY.printMessage();
        return Console.readLine();
    }

    public List<Integer> insertSixNum() throws IllegalArgumentException {
        List<Integer> lottoSixNum = new ArrayList<>();

        PrintInstruction.ENTER_NUM.printMessage();
        String[] userInputs = Console.readLine().split(",");

        CheckException checkException = new CheckException();
        for (String userInput : userInputs) {
            lottoSixNum.add(checkException.check_HaveChar_And_Convert(userInput));
        }

        return lottoSixNum;
    }

    public String insertOneNum() {
        PrintInstruction.ENTER_BONUS.printMessage();

        return Console.readLine();
    }


}
