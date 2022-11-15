package utils;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleUserInput {

    public String inputMoneyForLottos(){
        String moneyForLottos = Console.readLine();
        return moneyForLottos;
    }

    public String inputWinningNumbers(){
        String userInput = Console.readLine();
        return userInput;
    }

    public String inputBonusNumber(){
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
