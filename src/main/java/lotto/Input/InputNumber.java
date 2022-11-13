package lotto.Input;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputNumber {

    public String insertMoney() {
        PrintInstruction.BUY.printMessage();
        return Console.readLine();
    }

    public List<Integer> insertSixNum() {
        List<Integer> lottoSixNum = new ArrayList<>();
        PrintInstruction.ENTER_NUM.printMessage();
        String[] userInputs = Console.readLine().split(",");

        for (String userInput : userInputs) {
            try {
                lottoSixNum.add(Integer.parseInt(userInput));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(PrintError.NO_COMMA.getMessage());
            }
        }

        return lottoSixNum;
    }

    public String insertOneNum() {
        PrintInstruction.ENTER_BONUS.printMessage();

        return Console.readLine();
    }


}
