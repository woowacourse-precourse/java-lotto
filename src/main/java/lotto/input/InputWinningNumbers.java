package lotto.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputWinningNumbers {
    public static List<Integer> input() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateInput(input);

        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : input.split(",")) {
            winningNumbers.add(Integer.parseInt(number));
        }

        validateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    private static void validateInput(String input) {
        String[] numbers = input.split(",");
        for (String number : numbers) {
            validateInteger(number);
        }
    }

    private static void validateWinningNumbers(List<Integer> winningNumbers) {
        validateSize(winningNumbers);
        validateDuplication(winningNumbers);
        validateRange(winningNumbers);
    }

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 쉼표(,)를 기준으로 숫자를 입력해주세요. (예:1,2,3,4,5,6)");
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        Set<Integer> removeDuplication = new HashSet<>(numbers);
        if (numbers.size() != removeDuplication.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호들은 중복되면 안됩니다.");
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 개수는 6개 이어야 합니다.");
        }
    }
}
