package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static long askAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return parseLong(input, "[ERROR] 구입 금액은 숫자만 입력할 수 있습니다.");
    }

    public static List<Integer> askWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return parseIntegerList(input);
    }

    public static int askBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return parseInt(input, "[ERROR] 보너스 번호는 숫자만 입력할 수 있습니다.");
    }

    private static int parseInt(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(errorMessage);
            throw new IllegalArgumentException();
        }
    }

    private static long parseLong(String input, String errorMessage) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            System.out.println(errorMessage);
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> parseIntegerList(String input) {
        String[] numbers = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String number : numbers) {
            try {
                winningNumbers.add(Integer.parseInt(number.trim()));
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 당첨 번호는 숫자만 입력할 수 있습니다.");
                throw new IllegalArgumentException();
            }
        }
        return winningNumbers;
    }
}
