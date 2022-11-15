package lotto.console;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.ConsoleMessages.INPUT_BONUS;
import static lotto.constants.ConsoleMessages.INPUT_NUMBERS;

public class WinningConsole {

    public List<Integer> inputNumbers() {
        System.out.println(INPUT_NUMBERS);
        String input = Console.readLine();
        String []arr = input.split(",");
        List<Integer> list = new ArrayList<>();
        for(String s : arr) {
            list.add(Integer.parseInt(s));
        }

        return list;
    }

    public int inputBonus() {
        System.out.println(INPUT_BONUS);
        String input = Console.readLine();

        return Integer.parseInt(input);
    }
}
