package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public int inputMoney(){
        String amountOfMoney = Console.readLine();
        return Integer.parseInt(amountOfMoney);
    }
}
