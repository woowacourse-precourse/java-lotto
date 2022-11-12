package lotto.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class ConsoleInput {
    public static int getPurchaseAmount() throws Exception{
        String amount = Console.readLine();
        InputValidator.validateToParseInt(amount);
        return Integer.parseInt(amount);
    }

    public static int getBonusNumber() throws Exception {
        String number = Console.readLine();
        InputValidator.validateBonusNumber(number);
        return Integer.parseInt(number);
    }

    public static List<Integer> getWinningNumbers() throws Exception {
        String numbers = Console.readLine();
        InputValidator.validateWinningNumbers(numbers);
        return convertToNumbers(numbers);
    }

    private static List<Integer> convertToNumbers(String numbers) {
        List<Integer> result = new ArrayList<>();
        for (String number : numbers.split(",")) {
            result.add(Integer.parseInt(number));
        }
        return result;
    }
}
