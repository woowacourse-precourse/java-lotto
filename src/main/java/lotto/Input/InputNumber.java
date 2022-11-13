package lotto.Input;

import camp.nextstep.edu.missionutils.Console;

import javax.print.PrintException;

public class InputNumber {

    public int insertMoney() {
        PrintInstruction.BUY.getMessage();
        String userMoney = Console.readLine();

        if(Integer.parseInt(userMoney)%1000 != 0) {
            throw new IllegalArgumentException(PrintError.OUT_OF_MONEY_UNIT.getMessage());
        }
        return Integer.parseInt(userMoney)/1000;
    }
}
