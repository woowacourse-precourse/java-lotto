package lotto;

import java.util.NoSuchElementException;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Money {
    public static final String ERROR_MONEY = "[ERROR] 금액은 1 이상의 자연수여야 합니다.";
    public static final String ERROR_EMPTY = "[ERROR] 금액은 공백 또는 빈 문자열이 없어야 합니다.";
    public static final String ERROR_NOT_INT_MONEY = "[ERROR] 금액은 숫자로 입력해주세요.";
    private int money;

    private void validMoney(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(ERROR_MONEY);
        }
    }

    public static int init() {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = checkreadLine();
        validateEmpty(userInput);
        return changeInt(userInput);
    }

    private static String checkreadLine() {
        String input;
        try {
            input = readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException();
        }

        return input;
    }

    private static int changeInt(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_NOT_INT_MONEY);
        }
    }

    private static void validateEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY);
        }
    }
}
