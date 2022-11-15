package ui;

import camp.nextstep.edu.missionutils.Console;
import controller.InputNumber;

import java.util.List;

public class Input {

    public int getMoney() {
        int money = Integer.parseInt(Console.readLine());
        return money;
    }

    public List<Integer> getWinningNumber() {
        String userInput = Console.readLine();
        List<Integer> winningNumber = InputNumber.parseWinningNumber(userInput);
        return winningNumber;
    }

    public List<Integer> getBonusNumber() {
        String userInput = Console.readLine();
        List<Integer> bonusNumber = InputNumber.parseBonusNumber(userInput);
        return bonusNumber;
    }
}
