package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.Exception.*;
import static lotto.Output.requestBonusInput;
import static lotto.Output.requestWinNum;

public class UserInput {
    public static int moneyInput() throws IllegalArgumentException {
        String input = Console.readLine();
        moneyInputCheck(input);
        return Integer.parseInt(input);
    }

    public static int bonusNumInput(List<Integer> winNums) throws IllegalArgumentException {
        requestBonusInput();
        String input = Console.readLine();
        bonusErrorCheck(winNums, input);
        int bonus = Integer.parseInt(input);
        return bonus;
    }

    public static List<Integer> winNumInput() {
        requestWinNum();
        List<Integer> winNums = new ArrayList<>();
        String input = Console.readLine();
        winNumInputErrorCheck(input);
        String[] tmpNums = input.split(",");
        for (String e : tmpNums) {
            int num = Integer.parseInt(e);
            winNums.add(num);
        }
        return winNums;
    }

}
