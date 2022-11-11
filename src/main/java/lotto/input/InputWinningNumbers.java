package lotto.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputWinningNumbers {
    public static List<Integer> input() {
        String input = Console.readLine();
        validate(input);

        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : input.split(",")) {
            winningNumbers.add(Integer.parseInt(number));
        }

        return winningNumbers;
    }

    private static void validate(String input) {
        String[] numbers = input.split(",");
        for (String number : numbers) {
            validateInteger(number);
        }
    }

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 쉼표(,)를 기준으로 숫자를 입력해주세요. (예:1,2,3,4,5,6)");
        }
    }
}
