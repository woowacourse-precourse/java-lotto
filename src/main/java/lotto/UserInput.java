package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public static Long getPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        validatePurchaseMoney(input);

        return Long.parseLong(input);
    }

    private static void validatePurchaseMoney(String input) {
        if (!input.trim().matches("^[0-9]+$") || Long.parseLong(input) <= 0) {
            System.out.println("[ERROR] 금액은 자연수여야 합니다.");
            throw new IllegalArgumentException();
        }
        if (Long.parseLong(input) % 1000 != 0) {
            System.out.println("[ERROR] 구입 금액은 1000의 배수여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
