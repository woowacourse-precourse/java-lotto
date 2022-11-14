package lotto.presentation;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final String INPUT_REGEX = "^([0-9]+,)*([0-9]+)$";

    public static long inputAmount() {
        System.out.print("로또 구입 금액을 입력하세요: ");
        String input = Console.readLine();

        validateInputOfAmount(input);

        return Long.parseLong(input);
    }

    public static List<Integer> inputNumbers() {
        System.out.print("당첨 번호를 1,2,3,4,5,6 의 형식으로 입력하세요: ");
        String input = Console.readLine();

        validateInputOfNumbers(input);

        return Arrays
            .stream(input.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public static int inputNumber() {
        System.out.print("보너스 번호를 입력하세요: ");
        String input = Console.readLine();

        validateInputOfNumber(input);

        return Integer.parseInt(input);
    }

    private static void validateInputOfAmount(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("구매 금액은 필수로 입력되어야 합니다.");
        }

        if (!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("구매 금액은 숫자만 입력될 수 있습니다.");
        }
    }

    private static void validateInputOfNumbers(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("당첨 번호는 필수로 입력되어야 합니다.");
        }

        if (!input.matches(INPUT_REGEX)) {
            throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
        }
    }

    private static void validateInputOfNumber(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("보너스 번호는 필수로 입력되어야 합니다.");
        }

        if (!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("보너스 번호는 숫자만 입력될 수 있습니다.");
        }
    }
}
