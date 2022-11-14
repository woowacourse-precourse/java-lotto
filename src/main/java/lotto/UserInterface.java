package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInterface {
    public int inputOnlyNumber() {
        String input = Console.readLine();
        if (!validateInputOnlyNumber(input)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }

    public List<Integer> inputWinningNumbers() {
        String input = Console.readLine();
        if (!validateInputNumberAndComma(input)) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean validateInputOnlyNumber(String input) {
        return input.matches("[0-9]*");
    }

    private boolean validateInputNumberAndComma(String input) {
        return input.matches("[,0-9]*");
    }
}
