package lotto.Input;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputNumber {

    public int insertMoney() {
        PrintInstruction.BUY.getMessage();
        String userMoney = Console.readLine();

        if(Integer.parseInt(userMoney)%1000 != 0) {
            throw new IllegalArgumentException(PrintError.OUT_OF_MONEY_UNIT.getMessage());
        }
        return Integer.parseInt(userMoney)/1000;
    }

    public List<Integer> insertSixNum() {
        String[] userInputs = Console.readLine().split(",");
        List<Integer> lottoSixNum = new ArrayList<>();

        for (String userInput : userInputs) {
            try {
                lottoSixNum.add(Integer.parseInt(userInput));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(PrintError.NO_COMMA.getMessage());
            }
        }

        return lottoSixNum;
    }


}
