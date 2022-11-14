package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    private Input() {}

    public static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = getInteger(Console.readLine(), "[ERROR] 구입금액은 숫자여야 합니다.");
        validateAmount(amount);
        return amount;
    }

    protected static void validateAmount(int amount) {
        if (amount < 1000 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERRER] 구입금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public static List<Integer> inputWinNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return getIntegerList(input);
    }

    protected static List<Integer> getIntegerList(String input) throws IllegalArgumentException {
        try {
            return Arrays.stream(input.split(","))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] ',' 로 구분된 숫자를 입력해야 합니다.");
        }
    }

    public static int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return getInteger(Console.readLine(), "[ERROR] 보너스 번호는 숫자여야 합니다.");
    }

    protected static int getInteger(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

}
