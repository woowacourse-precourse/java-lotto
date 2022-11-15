package ui;

import camp.nextstep.edu.missionutils.Console;
import controller.InputNumber;

import java.util.List;

public class Input {

    public int getMoney() {
        try{
            int money = Integer.parseInt(Console.readLine());
            return money;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로만 이루어져야 합니다");
        }
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
