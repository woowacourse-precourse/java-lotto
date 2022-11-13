package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputException {
    static final int DIVIDENUMBER = 1000;
    static final int COMMACOUNT = 5;

    public static void isValidNumber(String input) {
        String compare = input.replaceAll("[0-9]", "");
        try {
            if (compare.length() != 0) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요");
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            throw illegalArgumentException;
        }
    }

    public static void isValidDivide(int input) {
        if (input % DIVIDENUMBER != 0) {
            try {
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요");
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
                throw illegalArgumentException;
            }
        }
    }

    public static void isValidWinningNumberLength(String input) {
        String replaceInput = input.replaceAll(",", "");
        if (input.length() - COMMACOUNT != replaceInput.length()) {
            try {
                throw new IllegalArgumentException("[ERROR] 6자리 숫자와 쉼표로 입력해 주세요");
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
                throw illegalArgumentException;
            }
        }
        isValidWinningNumber(replaceInput);
        isValidWinningNumberOverlap(input);
    }

    public static void isValidWinningNumber(String replaceInput) {
        String compare = replaceInput.replaceAll("[0-9]", "");
        try {
            if (compare.length() != 0) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요");
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            throw illegalArgumentException;
        }
    }

    public static void isValidWinningNumberOverlap(String input) {
        int[] winningNumbers = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> checkOverlap = new HashSet<>();
        for (int i = 0; i < winningNumbers.length; i++) {
            checkOverlap.add(winningNumbers[i]);
        }
        if (winningNumbers.length != checkOverlap.size()) {
            try {
                throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자를 입력하세요");
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
                throw illegalArgumentException;
            }
        }
        isValidWinningNumberRange(winningNumbers);
    }

    public static void isValidWinningNumberRange(int[] winningNumbers) {
        for (int i = 0; i < winningNumbers.length; i++) {
            if (winningNumbers[i] < 1 || winningNumbers[i] > 45) {
                try {
                    throw new IllegalArgumentException("[ERROR] 1~45 숫자를 입력하세요");
                } catch (IllegalArgumentException illegalArgumentException) {
                    System.out.println(illegalArgumentException.getMessage());
                    throw illegalArgumentException;
                }
            }
        }
    }
}
