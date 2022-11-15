package lotto;

import java.util.Arrays;

public class Validation {

    public static void validateInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력되었습니다.");
        }
    }

    public static void validateInteger(String[] numbers) {
        Arrays.stream(numbers)
                .forEach(Validation::validateInteger);
    }

    public static void validatePayment(String payment) {
        if (Integer.parseInt(payment) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 잘못된 금액이 입력되었습니다.");
        }
    }

    public static void validateSplitLengthSix(String[] winningNumbers) {
        if (winningNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 잘못 입력되었습니다.");
        }
    }

    public static void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 값이 아닙니다.");
        }
    }

    public static void validateRange(int[] numbers) {
        Arrays.stream(numbers)
                .forEach(Validation::validateRange);
    }

    public static void checkDuplicated(int[] winningNumbers, int number) {
        if (Arrays.stream(winningNumbers)
                .anyMatch(i -> i == number)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 입력되었습니다.");
        }
    }
}
