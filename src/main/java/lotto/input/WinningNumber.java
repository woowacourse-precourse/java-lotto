package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumber {

    public static String getUserInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

    public static void validate(String input) {
        isCommaCorrect(input);
        isSizeOfSix(input);
        isAllNumber(input);
    }

    public static List<Integer> getWinningNumbers(String input) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] numbers = input.split(",");
        for (String number : numbers) {
            winningNumbers.add(Integer.valueOf(number));
        }
        return winningNumbers;
    }

    private static void isCommaCorrect(String input) {
        if (! input.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 콤마(',')로 숫자를 이어서 입력해야 합니다.");
        }
    }
    private static void isSizeOfSix(String input) {
        String[] inputs = input.split(",");
        if (inputs.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개를 입력해야 합니다.");
        }
    }

    private static void isAllNumber(String input) {
        String[] inputs = input.split(",");
        for (String digits : inputs) {
            try {
                Integer.valueOf(digits);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
            }
        }
    }
}
