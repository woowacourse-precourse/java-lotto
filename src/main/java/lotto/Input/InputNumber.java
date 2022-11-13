package lotto.Input;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputNumber {

    public int insertMoney() {
        PrintInstruction.BUY.printMessage();
        String userMoney = Console.readLine();
        try {
            if (Integer.parseInt(userMoney) % 1000 != 0) {
                throw new IllegalArgumentException(PrintError.OUT_OF_MONEY_UNIT.getMessage());
            }
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException((PrintError.NOT_A_NUMBER.getMessage()));
        }
        return Integer.parseInt(userMoney)/1000;
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

    public int insertOneNum() {
        PrintInstruction.ENTER_BONUS.printMessage();

        int userInput;
        try {
            userInput = Integer.parseInt(Console.readLine());
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(PrintError.NOT_A_NUMBER.getMessage());
        }

        return userInput;
    }


}
