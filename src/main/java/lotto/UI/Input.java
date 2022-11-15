package lotto.UI;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Validation;

import java.util.ArrayList;
import java.util.List;


public class Input {
    private static int stringToInt(String input) {
        Validation.validNumber(input);
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
        Validation.validPurchase(input);
        return input;
    }

    public static List<Integer> getWinningNumbers() {
        String input = Console.readLine();
        String[] split = input.split(",");
        Validation.validWinning6Numbers(split);
        Validation.validWinningRepetition(split);
        List<Integer> numbers = toIntegerList(split);
        Validation.validRange(numbers);
        return numbers;
    }

    public static int getBonusNumber(List<Integer> winning) {
        int input = getInput();
        Validation.validBonusRepetition(input, winning);
        Validation.validRange(input);
        return input;
    }


}
