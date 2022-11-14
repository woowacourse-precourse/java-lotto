package lotto.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {
    public InputHandler() {
    }

    public static List<Integer> getWinningNumber() {
        String userInput = Console.readLine();
        List<Integer> winningNumber = validateType(userInput);
        validateSize(winningNumber);
        validateRange(winningNumber);
        validateUnique(winningNumber);
        return winningNumber;
    }

    public static int getBonusNumber() throws ExceptionHandler {
        String userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }

    private static List<Integer> validateType(String userInput) throws ExceptionHandler {
        List<Integer> validatedNumbers;
        validatedNumbers = Arrays.stream(userInput.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(validatedNumbers);
        return validatedNumbers;
    }

    private static void validateSize(List<Integer> userInput) {
        if (userInput.size() != CONSTANTS.LOTTO_COUNT.getNumbers()) {
            throw new ExceptionHandler("number exception");
        }
    }

    private static void validateRange(List<Integer> userInput) {
        for (Integer number :
                userInput) {
            if (number > CONSTANTS.MAXIMUM.getNumbers() || number < CONSTANTS.MINIMUM.getNumbers()) {
                throw new ExceptionHandler("number exception");
            }
        }
    }

    private static void validateUnique(List<Integer> userInput) {
        HashSet<Integer> numbers = new HashSet<>();
        for (Integer number :
                userInput) {
            if (numbers.add(number)) {
                throw new ExceptionHandler("test");
            }
        }
    }
}
