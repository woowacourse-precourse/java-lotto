package lotto.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {
    public InputHandler() {
    }

    public static List<Integer> getWinningNumber() {
        String userInput = Console.readLine();
        List<Integer> winningNumber = validateType(userInput);
        return winningNumber;
    }

    private static List<Integer> validateType(String userInput) throws IllegalArgumentException {
        List<Integer> validatedNumbers;
        validatedNumbers = Arrays.stream(userInput.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(validatedNumbers);
        return validatedNumbers;
    }

    private void validateRange(List<Integer> userInput) {

    }

    private void validateUnique(List<Integer> userInput) {

    }
}
