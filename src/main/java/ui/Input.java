package ui;

import camp.nextstep.edu.missionutils.Console;
import controller.InputNumber;

import java.util.List;

public class Input {

    int getMoney() {
        int money = Integer.parseInt(Console.readLine());
        return money;
    }

    List<Integer> getWinningNumber(){
        String userInput = Console.readLine();
        List<Integer> winningNumber = InputNumber.parseWinningNumber(userInput);
        return winningNumber;
    }
}
