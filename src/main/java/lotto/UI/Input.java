package lotto.UI;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Validation;

import java.util.ArrayList;
import java.util.List;


public class Input {
    private static int stringToInt(String input) {
        Validation.isNumber(input);
        return Integer.parseInt(input);
    }

    private static List<Integer> toIntegerList(String[] split) {
        List<Integer> numbers = new ArrayList<>();
        for (String str : split) {
            numbers.add(stringToInt(str));
        }
        return numbers;
    }

    private static int getInput() {
        String input = Console.readLine();
        return stringToInt(input);
    }

    public static int getPurchaseAmount() {
        int input = getInput();
        Validation.multipleBasicAmount(input);
        return input;
    }

    public static List<Integer> getWinningNumbers() {
        String input = Console.readLine();
        String[] split = input.split(",");
        Validation.canSplit(split);
        Validation.noDuplication(split);
        List<Integer> numbers = toIntegerList(split);
        Validation.inRange(numbers);
        Validation.validNumbersSize(numbers);
        return numbers;
    }

    public static int getBonusNumber(List<Integer> winning) {
        int input = getInput();
        Validation.noDuplication(input, winning);
        Validation.inRange(input);
        return input;
    }
}
