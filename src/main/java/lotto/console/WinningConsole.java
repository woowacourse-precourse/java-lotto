package lotto.console;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.ConsoleMessages.INPUT_BONUS;
import static lotto.constants.ConsoleMessages.INPUT_NUMBERS;
import static lotto.constants.ErrorMessages.INPUT_NUMBER_ERROR;

public class WinningConsole {

    public List<Integer> inputNumbers() {
        System.out.println(INPUT_NUMBERS);
        String input = Console.readLine();

        return toIntegerList(input);
    }

    private List<Integer> toIntegerList(String input) {
        String[] inputArr = input.split(",");
        List<Integer> list = new ArrayList<>();
        for (String each : inputArr) {
            try {
                list.add(Integer.parseInt(each));
            } catch (Exception e) {
                throw new IllegalArgumentException(INPUT_NUMBER_ERROR);
            }
        }

        return list;
    }

    public int inputBonus() throws IllegalArgumentException {
        System.out.println(INPUT_BONUS);
        String input = Console.readLine();

        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(INPUT_NUMBER_ERROR);
        }
    }

}
