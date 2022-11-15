package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static WinningNumbers getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> numbers = convertToList(input);

        int bonus = -1; // to be implemented

        return new WinningNumbers(numbers, bonus);
    }

    private static List<Integer> convertToList(String input) {
        return Arrays.stream(input.split(","))
                .filter(UserInput::validateNumber)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static boolean validateNumber(String input) {
        if (!input.trim().matches("^[0-9]+$")) {
            System.out.println("[ERROR] 로또 번호는 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        return true;
    }
}
