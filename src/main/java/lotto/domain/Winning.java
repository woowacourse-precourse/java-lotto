package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Winning {
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    private static Set<String> forDuplicateCheck = new HashSet<>();

    public Winning(String winningNumberInput, String bonusNumberInput) {
        this.winningNumber = new ArrayList<>();
        Arrays.stream(winningNumberInput.split(",")).
                mapToInt(Integer::parseInt).forEach(winningNumber::add);
        this.bonusNumber = Integer.parseInt(bonusNumberInput);
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
    public int getBonusNumber() {
        return bonusNumber;
    }

    // For UI with winning number input
    public static String winningNumberInput() {
        String winningNumberInput = Console.readLine();
        System.out.println();
        validateWinningNumberInput(winningNumberInput);
        return winningNumberInput;
    }

    // For UI with bonus number input
    public static String bonusNumberInput() {
        String bonusNumberInput = Console.readLine();
        System.out.println();
        validate(bonusNumberInput);
        return bonusNumberInput;
    }

    // Under Methods : for validate
    public static void validateWinningNumberInput(final String winningNumber) {
        String[] splitWinningNumber = winningNumber.split(",");

        if (splitWinningNumber.length != 6) {
            throw new IllegalArgumentException();
        }

        for (String i : splitWinningNumber){
            validate(i);
        }
    }

    public static void validate(final String input) {
        validateStringToInteger(input);
        validateRange(input);
        validateUniqueNumber(input);
    }

    public static  void validateStringToInteger(final String input) {
        try {
            Integer.parseInt(input);
        }catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateRange(final String input) {
        int intInput = Integer.parseInt(input);
        if (intInput < 1 || intInput > 45) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateUniqueNumber(final String input) {
        if (forDuplicateCheck.contains(input)) {
            System.out.println();
            throw new IllegalArgumentException();
        }
        forDuplicateCheck.add(input);
    }
}
