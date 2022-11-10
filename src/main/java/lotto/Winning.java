package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Winning {

    private final List<Integer> WINNING_NUMBERS;

    private Winning() {
        WINNING_NUMBERS = winningNumberInput();
    }

    public List<Integer> winningNumberInput() {
        String winningNumbers = Console.readLine();
        return TransformInputStringToList(winningNumbers);
    }

    public List<Integer> TransformInputStringToList(String input) {
        validateWinningNumberInput(input);
        String[] inputNumbers = input.split(",");

        List<Integer> numbers = new ArrayList<>();
        Arrays.stream(inputNumbers).mapToInt(Integer::parseInt).forEach(numbers::add);

        return numbers;
    }

    public void validateWinningNumberInput(String winningNumbers) {
        String[] winningNums = winningNumbers.split(",");

        for(String x : winningNums) {
            if (x.equals("")) {
                throw new IllegalArgumentException("[ERROR] 잘못된 입력 입니다.");
            }

            try {
                Integer.parseInt(x);
            }catch (Exception e) {
                throw new IllegalArgumentException("[ERROR] 잘못된 입력 입니다.");
            }
        }
    }
}
