package lotto.input;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {

    public static String requestAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

    public static int validatedAmount(String input) {
        isNumber(input);
        isMultipleOfThousand(input);
        return Integer.valueOf(input);
    }

    private static void isNumber(String input) {
        try {
            Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }
    }

    private static void isMultipleOfThousand(String input) {
        int number = Integer.valueOf(input);
        if (number % 1_000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 구입해야 합니다.");
        }
    }
}
