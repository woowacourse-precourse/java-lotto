package lotto.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputWinningNumbers {
    public static List<Integer> input() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateInput(input);

        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : input.split(",")) {
            winningNumbers.add(Integer.parseInt(number));
        }

        validateSize(winningNumbers);
        return winningNumbers;
    }

    private static void validateInput(String input) {
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

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 개수는 6개 이어야 합니다.");
        }
    }
}
