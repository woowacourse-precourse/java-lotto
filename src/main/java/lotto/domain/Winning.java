package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Winning {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    private static Set<String> forDuplicateCheck = new HashSet<>();

    public Winning(String winningNumberInput, String bonusNumberInput) {
        this.winningNumbers = new ArrayList<>();
        Arrays.stream(winningNumberInput.split(",")).
                mapToInt(Integer::parseInt).forEach(winningNumbers::add);
        this.bonusNumber = Integer.parseInt(bonusNumberInput);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
    public int getBonusNumber() {
        return bonusNumber;
    }

    // For UI with winning number input
    public static String winningNumberInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumberInput = Console.readLine();
        System.out.println();
        validateWinningNumberInput(winningNumberInput);
        return winningNumberInput;
    }

    // For UI with bonus number input
    public static String bonusNumberInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
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
            throw new IllegalArgumentException();
        }
        forDuplicateCheck.add(input);
    }
}
